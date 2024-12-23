package org.stierprogrammer.spawnPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.stierprogrammer.spawnPlugin.commands.SetSpawnCommand;
import org.stierprogrammer.spawnPlugin.commands.SpawnCommand;
import org.stierprogrammer.spawnPlugin.listeners.SpawnListeners;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
    }
}
