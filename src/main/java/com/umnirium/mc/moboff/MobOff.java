package com.umnirium.mc.moboff;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

public class MobOff extends JavaPlugin {
    MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getComponentLogger().info(mm.deserialize("<aqua>Plugin successfully enabled</aqua>"));
        getComponentLogger().info(mm.deserialize("<white>Consider supporting here:</white> <yellow><click:open_url:'https://ko-fi.com/H2H61DN2C9'>https://ko-fi.com/H2H61DN2C9</click></yellow>"));
    }

    @Override
    public void onDisable() {
        getComponentLogger().info(mm.deserialize("<aqua>Plugin successfully disabled</aqua>"));
    }
}