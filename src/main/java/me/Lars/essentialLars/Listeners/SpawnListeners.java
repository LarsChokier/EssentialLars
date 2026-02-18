package me.Lars.essentialLars.Listeners;

import me.Lars.essentialLars.EssentialLars;
import me.Lars.essentialLars.Util.Messages;
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
                player.sendMessage(Messages.positive("You have been teleported to spawn."));

            }

        }

    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        Location location = plugin.getConfig().getLocation("spawn");

        if (location != null){

            e.setRespawnLocation(location);
            player.sendMessage(Messages.positive("You have been teleported to spawn."));

        }else {

            player.sendMessage(Messages.error("No spawn location found."));

        }
    }

}
