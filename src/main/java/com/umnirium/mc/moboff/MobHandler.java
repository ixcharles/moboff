package com.umnirium.mc.moboff;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;


public class MobHandler {
    private final ConfigManager config;

    public MobHandler(ConfigManager config) {
        this.config = config;
    }

    public void clearDisabledMobs() {
        for (World world : Bukkit.getServer().getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if ((entity instanceof LivingEntity) && !(entity instanceof Player)) {
                    String entityType = entity.getType().name();

                    if (config.getDisabledMobs().contains(entityType)) {
                        entity.remove();
                    }
                }
            }
        }
    }
}
