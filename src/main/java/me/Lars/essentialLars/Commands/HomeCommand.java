package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import me.Lars.essentialLars.Util.Messages;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private final EssentialLars plugin;

    public HomeCommand(EssentialLars plugin) {
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
            player.sendMessage(Messages.error("Incorrect usage. Use: /home <name>"));
            return true;
        }

        String homeName = args[0];

        String path = "homes." + player.getName() + "." + homeName;
        Location home = plugin.getConfig().getLocation(path);

        if (home == null) {
            player.sendMessage(Messages.error("Home " + homeName + " does not exist."));
            return true;
        }

        player.teleport(home);

        player.sendMessage(Messages.positive("Teleporting to home " + homeName + "..."));

        return true;
    }
}
