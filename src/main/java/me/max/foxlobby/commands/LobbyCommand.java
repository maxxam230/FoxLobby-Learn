package me.max.foxlobby.commands;

import me.max.foxlobby.FoxLobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LobbyCommand implements CommandExecutor {

    //lobby (TELEPORT)
    //lobby set (SAVED LOCATION)

    FoxLobby plugin;

    public LobbyCommand(FoxLobby instance) {
        plugin = instance;
    }

//    public void test(){
//        FoxLobby.instance.getConfigLocation();
//    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("lobby")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length < 1) {
                    if (plugin.getConfig().contains("lobbyspawn")) {
                        player.teleport(getConfigLocation());
                    } else {
                        player.sendMessage("§4deze is niet ingesteld!");
                    }
                }
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("set")){
                        saveLocationInConfig(player.getLocation());
                        player.sendMessage("§alobby spawn opgeslagen");
                    }

                }
            }
        }
        return false;
    }


    private void saveLocationInConfig(Location location){
        plugin.getConfig().set("lobbyspawn.world", location.getWorld().getName());
        plugin.getConfig().set("lobbyspawn.x", location.getX());
        plugin.getConfig().set("lobbyspawn.y",location.getY());
        plugin.getConfig().set("lobbyspawn.z", location.getZ());
        plugin.getConfig().set("lobbyspawn.yaw",location.getYaw());
        plugin.getConfig().set("lobbyspawn.pitch", location.getPitch());
        plugin.saveConfig();
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










