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

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return true;
        }

        Player player = (Player) sender;
        Location location = plugin.getConfig().getLocation("spawn");

        if (location != null){
            player.teleport(location);
            player.sendMessage(ChatColor.DARK_GRAY + "["
                    + ChatColor.AQUA + "Server"
                    + ChatColor.DARK_GRAY + "] "
                    + ChatColor.GRAY + "Teleporting to "
                    + ChatColor.YELLOW + "Spawn"
                    + ChatColor.GRAY + "...");
        } else {
            player.sendMessage(ChatColor.DARK_GRAY + "["
                    + ChatColor.AQUA + "Server"
                    + ChatColor.DARK_GRAY + "] "
                    + ChatColor.RED + "Error: "
                    + ChatColor.GRAY + "The spawn location has not been set yet.");
        }

        return true;
    }
}

