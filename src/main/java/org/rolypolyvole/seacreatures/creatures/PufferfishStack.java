package org.rolypolyvole.seacreatures.creatures;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.PufferFish;
import org.jetbrains.annotations.NotNull;
import org.rolypolyvole.seacreatures.SeaCreaturesPlugin;

public class PufferfishStack extends AbstractSeaCreature<PufferFish> {


    public PufferfishStack(@NotNull Location location, Player player, SeaCreaturesPlugin main) {
        super(location, player, EntityType.PUFFERFISH, 20, main);
    }

    @Override
    public void startTasks() {

    }

    @Override
    public PufferFish getEntity() {
        return null;
    }

    @Override
    public double getVelocityScalar() {
        return 0;
    }
}
