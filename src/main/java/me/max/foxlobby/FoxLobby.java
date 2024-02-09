package me.max.foxlobby;

import me.max.foxlobby.commands.LobbyCommand;
import me.max.foxlobby.listener.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class FoxLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("lobby").setExecutor(new LobbyCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);

    }


//
//    @Override
//    public void onDisable() {
//        System.out.println("JULLIE ZIJN ALLEMAAL FUCKED! YAY");
//    }

}
