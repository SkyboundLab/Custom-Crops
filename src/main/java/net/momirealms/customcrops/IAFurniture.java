package net.momirealms.customcrops;

import dev.lone.itemsadder.api.CustomFurniture;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

public class IAFurniture {

    static FileConfiguration config = CustomCrops.instance.getConfig();

    public static void placeFurniture(String name, Location location){
        CustomFurniture.spawn(name,location.getWorld().getBlockAt(location));
    }

    public static boolean getFromLocation(Location location, World world){
        for(Entity entity : world.getNearbyEntities(location,0,0,0)){
            if(entity instanceof ArmorStand){
                if(CustomFurniture.byAlreadySpawned((ArmorStand) entity) != null){
                    if(CustomFurniture.byAlreadySpawned((ArmorStand) entity).getNamespacedID().equalsIgnoreCase(config.getString("config.sprinkler-1")) || CustomFurniture.byAlreadySpawned((ArmorStand) entity).getNamespacedID().equalsIgnoreCase(config.getString("config.sprinkler-2"))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
