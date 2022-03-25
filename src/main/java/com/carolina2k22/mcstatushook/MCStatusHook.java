package com.carolina2k22.mcstatushook;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public final class MCStatusHook extends JavaPlugin {

    public static JavaPlugin plugin = null;
    private final OkHttpClient httpClient = new OkHttpClient();
    final String prefix = "[MCStatusHook] ";

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getLogger().log(Level.INFO, prefix + "Plugin startup reached, sending webhook...");

        try {
            webhookRequest(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().log(Level.INFO, prefix + "Plugin shutdown reached, sending webhook...");

        try {
            webhookRequest(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void webhookRequest(Boolean starting) throws Exception {
        Request getRequest = new Request.Builder()
                .url(Objects.requireNonNull(config.getString("webhook_url")))
                .build();

        try (Response response = httpClient.newCall(getRequest).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Gson gson = new Gson();
            WebhookData webhook_data = gson.fromJson(response.body().string(), WebhookData.class);

            String webhook_message;

            if (starting) {
                webhook_message = config.getString("online_msg");
            } else {
                webhook_message = config.getString("offline_msg");
            }

            RequestBody formBody = new FormBody.Builder()
                    .add("content", webhook_message)
                    .build();

            Request postRequest = new Request.Builder()
                    .url("https://discord.com/api/v9/webhooks/" + webhook_data.id + "/" + webhook_data.token)
                    .post(formBody)
                    .build();

            try (Response finalResponse = httpClient.newCall(postRequest).execute()) {
                if (!finalResponse.isSuccessful()) throw new IOException("Unexpected code " + finalResponse);
                Bukkit.getLogger().log(Level.INFO, prefix + "Webhook sent.");
            }
        }
    }
}
