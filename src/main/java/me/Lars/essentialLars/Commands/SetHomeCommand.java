package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import me.Lars.essentialLars.Util.Messages;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private final EssentialLars plugin;

    public SetHomeCommand(EssentialLars plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.error("Only players can execute this command."));
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(Messages.error("Incorrect usage. Use: /sethome <name>"));
            return true;
        }

        String homeName = args[0];
        Location loc = player.getLocation();

        plugin.getConfig().set("homes." + player.getName() + "." + homeName, loc);
        plugin.saveConfig();

        player.sendMessage(Messages.positive("Home " + homeName + " has been set."));

        return true;
    }
}
