package me.Lars.essentialLars;

import me.Lars.essentialLars.Commands.SetSpawnCommand;
import me.Lars.essentialLars.Commands.SpawnCommand;
import me.Lars.essentialLars.Commands.gmcCommand;
import me.Lars.essentialLars.Commands.gmsCommand;
import me.Lars.essentialLars.Listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialLars extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        //===SPAWN===
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);

        //===GAMEMODE COMMANDS===
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gms").setExecutor(new gmsCommand());
    }
}
