package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import me.Lars.essentialLars.Util.Messages;
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
            sender.sendMessage(Messages.error("Only players can execute this command."));
            return true;
        }

        Player player = (Player) sender;
        Location location = plugin.getConfig().getLocation("spawn");

        if (location != null){
            player.teleport(location);
            player.sendMessage(Messages.positive("Teleporting to spawn..."));
        } else {
            player.sendMessage(Messages.error("The spawn location has not been set yet."));
        }

        return true;
    }
}

