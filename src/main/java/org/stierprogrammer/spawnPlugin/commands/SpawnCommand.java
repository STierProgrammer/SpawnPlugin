package org.stierprogrammer.spawnPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.stierprogrammer.spawnPlugin.SpawnPlugin;

public class SpawnCommand implements CommandExecutor {
    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            String[] strings
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");

            return true;
        }

        Location location = plugin.getConfig().getLocation("spawn");

        if (location != null) {
            player.teleport(location);

            player.sendMessage(ChatColor.GREEN + "You have been teleported to the spawn point!");
        }
        else {
            player.sendMessage(ChatColor.RED + "There is no spawn point set!");
        }

        return true;
    }
}
