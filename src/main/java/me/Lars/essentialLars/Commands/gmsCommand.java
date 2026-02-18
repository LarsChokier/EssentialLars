package me.Lars.essentialLars.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.Lars.essentialLars.Util.Messages;

public class gmsCommand implements CommandExecutor {




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.error("Only players can execute this command."));
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0){

            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(Messages.positive("Your gamemode has been changed to survival."));

        }else if (args.length == 1){

            String playerName = args[0];

            Player target = Bukkit.getPlayer(playerName);

            if (target == null) {
                player.sendMessage(Messages.error("Player " + playerName + " is not online."));
                return true;
            }

            target.setGameMode(GameMode.SURVIVAL);

            player.sendMessage(Messages.positive("You changed " + target.getName() + "'s gamemode to survival."));

            target.sendMessage(Messages.positive("Your gamemode has been changed to survival by " + player.getName() + "."));

        }else {

            player.sendMessage(Messages.error("Incorrect usage. Use: /gms <PlayerName>"));

        }
        return true;
    }
}
