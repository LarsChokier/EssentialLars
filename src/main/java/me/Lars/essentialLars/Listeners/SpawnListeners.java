package me.Lars.essentialLars.Listeners;

import me.Lars.essentialLars.EssentialLars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final EssentialLars plugin;
    public SpawnListeners(EssentialLars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSpawn(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (!e.getPlayer().hasPlayedBefore()){

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null){

                player.teleport(location);
                player.sendMessage(ChatColor.GOLD + "You have been teleported to spawn point!");

            }

        }

    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        Location location = plugin.getConfig().getLocation("spawn");

        if (location != null){

            e.setRespawnLocation(location);
            player.sendMessage(ChatColor.GOLD + "You have been teleported to spawn point!");

        }else {

            player.sendMessage(ChatColor.RED + "No spawn Location found");

        }
    }

}
