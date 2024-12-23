package org.stierprogrammer.spawnPlugin.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.stierprogrammer.spawnPlugin.SpawnPlugin;

public class SetSpawnCommand implements CommandExecutor {
    private final SpawnPlugin plugin;

    public SetSpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");

            return true;
        }

        Location location = player.getLocation();

        plugin.getConfig().set("spawn", location);

        plugin.saveConfig();

        player.sendMessage(ChatColor.GREEN + "Spawn has been set!");

        return true;
    }
}
