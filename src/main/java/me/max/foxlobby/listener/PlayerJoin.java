package me.max.foxlobby.listener;

import me.max.foxlobby.FoxLobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    FoxLobby plugin;

    public PlayerJoin(FoxLobby instance) {
        plugin = instance;
    }

    @EventHandler
    //TIP: Gebruik de events
    public void onJoin(PlayerJoinEvent event){
        //lobbyspawn
        if (plugin.getConfig().contains("lobbyspawn")){
            event.getPlayer().teleport(getConfigLocation());
        }
    }


    private Location getConfigLocation(){
        String world = plugin.getConfig().getString("lobbyspawn.world");
        double x = plugin.getConfig().getDouble("lobbyspawn.x");
        double y = plugin.getConfig().getDouble("lobbyspawn.y");
        double z = plugin.getConfig().getDouble("lobbyspawn.z");
        double yaw = plugin.getConfig().getDouble("lobbyspawn.yaw");
        double pitch = plugin.getConfig().getDouble("lobbyspawn.pitch");
        return new Location(Bukkit.getWorld(world),x,y,z, (float) yaw,(float) pitch);
    }


}
