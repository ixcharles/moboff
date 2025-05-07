package com.umnirium.mc.moboff;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CommandHandler {
    private final ConfigManager config;

    public CommandHandler(ConfigManager config) {
        this.config = config;
    }

    public void register(Commands commands, JavaPlugin plugin) {
        commands.register(
                Commands.literal("moboff")
                        .requires(source -> source.getSender().hasPermission("moboff.command"))
                        .then(
                                Commands.literal("reload")
                                        .requires(source -> source.getSender().hasPermission("moboff.command.reload"))
                                        .executes(ctx -> {
                                                    config.reloadConfig();
                                                    ctx.getSource().getSender().sendRichMessage(config.getMessage("reload-success"));

                                                    return Command.SINGLE_SUCCESS;
                                                }
                                        )
                        )
                        .then(
                              Commands.literal("support")
                                        .requires(source -> source.getSender().hasPermission("moboff.command.support"))
                                        .executes(ctx -> {
                                              ctx.getSource().getSender().sendRichMessage("<gold>[MobOff]</gold> <white>Thank you for using my plugin!</white>");
                                              ctx.getSource().getSender().sendRichMessage("<gold>[MobOff]</gold> <white>Consider supporting here:</white> <yellow><click:open_url:'https://ko-fi.com/H2H61DN2C9'>https://ko-fi.com/H2H61DN2C9</click></yellow>");

                                              return Command.SINGLE_SUCCESS;
                                        })
                        )
                        .then(
                                Commands.literal("version")
                                        .requires(source -> source.getSender().hasPermission("moboff.command.version"))
                                        .executes(ctx -> {
                                            ctx.getSource().getSender().sendRichMessage("<gold>[MobOff]</gold> <white>Version 1.0.0</white>");

                                            return Command.SINGLE_SUCCESS;
                                        })
                        )
                        .then(
                                Commands.literal("help")
                                        .requires(source -> source.getSender().hasPermission("frostbite.command.help"))
                                        .executes(ctx -> {
                                            ctx.getSource().getSender().sendRichMessage("""
                                                    <gold>[MobOff]</gold> <white>Full control over mob spawning</white>\
                                                    
                                                    <aqua>/moboff help :</aqua> <white>Get MobOff commands</white>\
                                                    
                                                    <aqua>/moboff support :</aqua> <white>Support me with a coffee!</white>\
                                                    
                                                    <aqua>/moboff reload :</aqua> <white>Reload config and messages</white>\
                                                    
                                                    <aqua>/moboff version :</aqua> <white>Get plugin version</white>""");

                                            return Command.SINGLE_SUCCESS;
                                        })
                        )
                        .build(),
                "MobOff commands",
                List.of("entityoff")
        );
    }
}