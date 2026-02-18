package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelHomeCommand implements CommandExecutor {

    private final EssentialLars plugin;

    public DelHomeCommand(EssentialLars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.DARK_GRAY + "["
                    + ChatColor.AQUA + "Server"
                    + ChatColor.DARK_GRAY + "] "
                    + ChatColor.RED + "Error: "
                    + ChatColor.GRAY + "Incorrect usage. Use: "
                    + ChatColor.YELLOW + "/delhome <name>");
            return true;
        }

        String homeName = args[0];
        String path = "homes." + player.getName() + "." + homeName;

        if (!plugin.getConfig().contains(path)){
            player.sendMessage(ChatColor.DARK_GRAY + "["
                    + ChatColor.AQUA + "Server"
                    + ChatColor.DARK_GRAY + "] "
                    + ChatColor.RED + "Error: "
                    + ChatColor.GRAY + "Home "
                    + ChatColor.YELLOW + homeName
                    + ChatColor.GRAY + " does not exist.");
            return true;
        }

        plugin.getConfig().set(path, null);
        plugin.saveConfig();
        player.sendMessage(ChatColor.DARK_GRAY + "["
                + ChatColor.AQUA + "Server"
                + ChatColor.DARK_GRAY + "] "
                + ChatColor.GREEN + "Success: "
                + ChatColor.GRAY + "Home "
                + ChatColor.YELLOW + homeName
                + ChatColor.GRAY + " has been deleted.");


        return true;
    }
}
