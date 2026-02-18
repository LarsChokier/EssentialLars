package me.Lars.essentialLars.Commands;

import me.Lars.essentialLars.EssentialLars;
import me.Lars.essentialLars.Util.Messages;
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
            sender.sendMessage(Messages.error("Only players can execute this command."));
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(Messages.error("Incorrect usage. Use: /delhome <name>"));
            return true;
        }

        String homeName = args[0];
        String path = "homes." + player.getName() + "." + homeName;

        if (!plugin.getConfig().contains(path)){
            player.sendMessage(Messages.error("Home " + homeName + " does not exist."));
            return true;
        }

        plugin.getConfig().set(path, null);
        plugin.saveConfig();
        player.sendMessage(Messages.positive("Home " + homeName + " has been deleted."));


        return true;
    }
}
