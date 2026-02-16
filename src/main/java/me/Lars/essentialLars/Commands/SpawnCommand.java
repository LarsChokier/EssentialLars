package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final EssentialLars plugin;

    public SpawnCommand(EssentialLars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){

                player.teleport(location);
                player.sendMessage(ChatColor.GOLD + "You have been teleported to spawn point!");

            } else {

                player.sendMessage(ChatColor.RED + "There is no spawnpoint set :(");

            }

        }

        return false;
    }
}

