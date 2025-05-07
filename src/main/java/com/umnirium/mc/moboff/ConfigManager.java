package com.umnirium.mc.moboff;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class ConfigManager {
    static final MobOff plugin = new MobOff();

    private FileConfiguration messagesConfig = createMessagesFile();

    public void reloadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();

        reloadMessages();
    }

    public @NotNull YamlConfiguration createMessagesFile() {
        File messagesFile = new File(plugin.getDataFolder(), "messages.yml");

        if (!messagesFile.exists()) {
            plugin.saveResource("messages.yml", false);
        }

        return YamlConfiguration.loadConfiguration(messagesFile);
    }

    public void reloadMessages() {
        messagesConfig = createMessagesFile();
    }

    public String getMessage(String path) {
        return messagesConfig.getString(path);
    }

    public List<String> getDisabledMobs() {
        return plugin.getConfig().getStringList("disabled-mobs");
    }
}