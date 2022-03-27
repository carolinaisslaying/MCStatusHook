# MCStatusHook
MCStatusHook is a lightweight and simple plugin that sends a message regarding a server's status to Discord via webhook.

[![GNU General Public License v3.0](https://img.shields.io/github/license/Carolina2k22/MCStatusHook?&logo=github)](LICENSE)
[![Build](https://github.com/Carolina2k22/MCStatusHook/actions/workflows/build.yml/badge.svg)](https://github.com/Carolina2k22/MCStatusHook/actions/workflows/build.yml)
[![Join us on Discord](https://img.shields.io/discord/956852101714169888.svg?label=&logo=discord&logoColor=ffffff&color=5865F2&labelColor=5865F2)](https://discord.gg/AnTJtEJqeP)

## Setup
1. Download the plugin's .jar file, and place it in your server's `plugin` folder.
2. Start (or restart) your server - you __shouldn't__ be using the `/reload` command on your server if you are in the first place.
3. On the Discord channel you want to send online and offline messages to, head to "Edit Channel".
4. Once in the Edit Channel overview, navigate to the "Integrations" tab on the left.
5. Press the Webhooks box and then press on the "New Webhook" button.
6. Customise the webhook name and profile picture to your choosing - this will be the profile picture and name of the webhook's message.
7. Press "Copy Webhook URL".
8. Navigate to your minecraft server's `plugin` folder, then enter the `MCStatusHook` folder.
9. Open the `config.yml` file in Notepad (or your preferred text editor).
10. Paste the webhook URL in place of the existing url next to the `webhook_url` config setting.
11. Customise the `online_msg` and `offline_msg` values to your liking, you can set any message and the webhook will send it!
12. Restart your server and voila!

https://user-images.githubusercontent.com/38713645/160095742-b341a18e-ba61-473c-ab34-a3a3a99bb9e0.mp4

## Image Examples
These are the example messages from the video setup.

![image](https://user-images.githubusercontent.com/38713645/160095410-66acdcb4-22e7-4e54-a713-35bed00774fc.png)
![image](https://user-images.githubusercontent.com/38713645/160095497-5d7b1d95-54d9-4cf8-b213-1b2ec64d33ed.png)





