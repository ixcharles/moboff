package com.umnirium.mc.moboff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SpawnListener implements Listener {
    private final ConfigManager config;

    public SpawnListener(ConfigManager config) {
        this.config = config;
    }

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        String entity = event.getEntityType().name();

        if (config.getDisabledMobs().contains(entity)) {
            event.setCancelled(true);
        }
    }
}
