/*package net.mikkel.mrt.effect;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import java.util.UUID;
import net.minecraft.village.VillagerGossips;
import net.minecraft.village.VillageGossipType;

public class ReputableEffect extends MobEffect
{
    public ReputableEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier)
    {
        if (!(entity instanceof net.minecraft.world.entity.player.Player)) return;
        UUID playerUUID = entity.getUUID();
        Level world = entity.level();
        double radius = 16.0; // example range

        for (Entity e : world.getEntities(entity, entity.getBoundingBox().inflate(radius)))
        {
            if (e instanceof Villager villager)
            {
                net.mikkel.mrt.effect.VillagerGossips gossips = villager.getGossips();
                // for each gossip type you care about, set a high positive value
                gossips.startGossip(playerUUID, VillageGossipType.MAJOR_POSITIVE, 100);
                gossips.startGossip(playerUUID, VillageGossipType.MINOR_POSITIVE, 100);
                // optionally clear negative gossips
                // (no built‑in method, you might need to merge or remove negative entries manually)
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier)
    {
        return false; // do once on apply
    }

    @Override
    public void applyInstantEffect(Entity source, Entity indirect, LivingEntity entity, int amplifier, double factor)
    {
        // alternatively, apply instantly at potion drinking
        applyEffectTick(entity, amplifier);
    }
}*/