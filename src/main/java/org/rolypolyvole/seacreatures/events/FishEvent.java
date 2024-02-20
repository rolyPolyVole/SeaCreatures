package org.rolypolyvole.seacreatures.events;

import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.rolypolyvole.seacreatures.SeaCreaturesPlugin;
import org.rolypolyvole.seacreatures.creatures.LakeSquid;

import java.util.Random;

public class FishEvent implements Listener {
    private final SeaCreaturesPlugin main;
    private final Random random = new Random();
    public FishEvent(SeaCreaturesPlugin main) {
        this.main = main;
    } //"Pipe" principle by stephen

    @EventHandler
    public void onFish(@NotNull PlayerFishEvent event) {
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            if (random.nextDouble() < 0.01) {
                //Drop luck potion
                event.setCancelled(true);
                return;
            }

            if (random.nextDouble() < 0.99) {
                Player player = event.getPlayer();
                FishHook hook = event.getHook();

                LakeSquid lakeSquid = new LakeSquid(hook.getLocation(), player, main);
                Squid squidEntity = lakeSquid.getEntity();
                lakeSquid.applyBuffs();
                lakeSquid.startTasks();

                Vector velocity = new Vector(
                    player.getX() - squidEntity.getX(),
                    player.getY() - squidEntity.getY(),
                    player.getZ() - squidEntity.getZ()
                );

                squidEntity.setVelocity(
                    velocity
                        .normalize()
                        .multiply(lakeSquid.getVelocityScalar())
                );

                event.setCancelled(true);
            }
        }
    }
}
