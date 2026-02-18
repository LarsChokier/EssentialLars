package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import me.Lars.essentialLars.Util.Messages;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SetSpawnCommand implements CommandExecutor {

    private final EssentialLars plugin;
    public SetSpawnCommand(EssentialLars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.error("Only players can execute this command."));
            return true;
        }

        Player player = (Player) sender;
        Location location = player.getLocation();

        // Save location
        plugin.getConfig().set("spawn", location);
        plugin.saveConfig();

        player.sendMessage(Messages.positive("The server spawn has been set."));

        return true;
    }
}

