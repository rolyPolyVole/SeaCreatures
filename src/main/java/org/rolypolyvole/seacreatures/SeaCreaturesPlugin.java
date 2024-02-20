package org.rolypolyvole.seacreatures;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.rolypolyvole.seacreatures.events.FishEvent;

public class SeaCreaturesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new FishEvent(this), this);
    }
}
