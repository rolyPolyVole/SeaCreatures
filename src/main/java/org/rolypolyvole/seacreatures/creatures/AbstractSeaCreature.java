package org.rolypolyvole.seacreatures.creatures;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.rolypolyvole.seacreatures.SeaCreatures;

import java.util.Objects;

public abstract class AbstractSeaCreature<E extends LivingEntity> {
    protected final SeaCreatures main;
    protected final E creature;
    public final Location location;
    public final Player player;
    public AbstractSeaCreature(Location location, Player player, EntityType type, double health, SeaCreatures main) {
        this.location = location;
        this.player = player;
        this.main = main;
        this.creature = (E) location.getWorld().spawnEntity(location, type);

        Objects.requireNonNull(creature.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(health);
    }

    public abstract void startTasks();
    public abstract E getEntity();
    public abstract double getVelocityScalar();

}
