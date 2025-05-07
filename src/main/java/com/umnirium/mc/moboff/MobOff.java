package com.umnirium.mc.moboff;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnstableApiUsage")
public class MobOff extends JavaPlugin {
    MiniMessage mm = MiniMessage.miniMessage();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        ConfigManager config = new ConfigManager();

        LifecycleEventManager<@NotNull Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            new CommandHandler(config).register(commands, this);
        });

        getComponentLogger().info(mm.deserialize("<aqua>Plugin successfully enabled</aqua>"));
        getComponentLogger().info(mm.deserialize("<white>Consider supporting here:</white> <yellow><click:open_url:'https://ko-fi.com/H2H61DN2C9'>https://ko-fi.com/H2H61DN2C9</click></yellow>"));
    }

    @Override
    public void onDisable() {
        getComponentLogger().info(mm.deserialize("<aqua>Plugin successfully disabled</aqua>"));
    }
}