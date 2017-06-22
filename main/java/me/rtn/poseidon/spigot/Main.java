package me.rtn.poseidon.spigot;

import org.bukkit.plugin.java.JavaPlugin;



public final class Main extends JavaPlugin {

    private static Main spigotInstance;
    @Override
    public void onEnable() {
        spigotInstance = this;


        //lambda streaming not working?!?!?!
    }

    @Override
    public void onDisable() {
        spigotInstance = this;
    }

    public static Main getSpigotInstance() {
        return spigotInstance;
    }
}
