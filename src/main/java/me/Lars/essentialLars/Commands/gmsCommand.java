package me.Lars.essentialLars.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmsCommand implements CommandExecutor {




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 0){

                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.DARK_GRAY + "["
                        + ChatColor.AQUA + "Server"
                        + ChatColor.DARK_GRAY + "] "
                        + ChatColor.GREEN + "Success: "
                        + ChatColor.GRAY + "Your gamemode has been changed to "
                        + ChatColor.YELLOW + "creative"
                        + ChatColor.GRAY + ".");

            }else if (args.length == 1){

                String playerName = args[0];

                Player target = Bukkit.getPlayer(playerName);

                target.setGameMode(GameMode.CREATIVE);


                player.sendMessage(ChatColor.DARK_GRAY + "["
                        + ChatColor.AQUA + "Server"
                        + ChatColor.DARK_GRAY + "] "
                        + ChatColor.GREEN + "Success: "
                        + ChatColor.GRAY + "You changed "
                        + ChatColor.YELLOW + target.getName()
                        + ChatColor.GRAY + "'s gamemode to "
                        + ChatColor.YELLOW + "creative"
                        + ChatColor.GRAY + ".");

                target.sendMessage(ChatColor.DARK_GRAY + "["
                        + ChatColor.AQUA + "Server"
                        + ChatColor.DARK_GRAY + "] "
                        + ChatColor.GREEN + "Success: "
                        + ChatColor.GRAY + "Your gamemode has been changed to "
                        + ChatColor.YELLOW + "creative"
                        + ChatColor.GRAY + " by "
                        + ChatColor.YELLOW + player.getName()
                        + ChatColor.GRAY + ".");

            }else {

                player.sendMessage(ChatColor.DARK_GRAY + "["
                        + ChatColor.AQUA + "Server"
                        + ChatColor.DARK_GRAY + "] "
                        + ChatColor.RED + "Error: "
                        + ChatColor.GRAY + "Incorrect usage. Use: "
                        + ChatColor.YELLOW + "/gamemode <mode>");


            }
        }
        return false;
    }
}
