package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Set;

public class HomesCommand implements CommandExecutor {

    private final EssentialLars plugin;

    public HomesCommand(EssentialLars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return true;
        }

        Player player = (Player) sender;

        ConfigurationSection section = plugin.getConfig().getConfigurationSection("homes." + player.getName());

        if (section == null) {
            player.sendMessage(ChatColor.DARK_GRAY + "["
                    + ChatColor.AQUA + "Server"
                    + ChatColor.DARK_GRAY + "] "
                    + ChatColor.RED + "Error: "
                    + ChatColor.GRAY + "You don't have any homes set.");
        } else {
            Set<String> homeList = section.getKeys(false);
            String list = String.join(", ", homeList);
            player.sendMessage(ChatColor.DARK_GRAY + "["
                    + ChatColor.AQUA + "Server"
                    + ChatColor.DARK_GRAY + "] "
                    + ChatColor.GREEN + "Homes: "
                    + ChatColor.YELLOW + list);
        }


        return true;
    }

}
