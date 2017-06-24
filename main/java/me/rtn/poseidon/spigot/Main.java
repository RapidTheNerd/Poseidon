package me.rtn.poseidon.spigot;

import me.rtn.poseidon.spigot.listeners.PlayerJoin;
import me.rtn.poseidon.spigot.managers.WhitelistManager;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

    private static Main spigotInstance;

    @Override
    public void onEnable() {
        spigotInstance = this;

        getServer().getPluginManager().registerEvents(new WhitelistManager(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        //lambda's hate me
    }

    @Override
    public void onDisable() {
        spigotInstance = this;
    }

    public static Main getSpigotInstance() {
        return spigotInstance;
    }
}
