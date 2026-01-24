package net.mikkel.mrt.effect;


import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import net.neoforged.neoforge.common.extensions.IHolderExtension;
import net.neoforged.neoforge.common.extensions.IHolderLookupProviderExtension;
import net.neoforged.neoforge.common.extensions.IHolderSetExtension;

public class AstralTravel_Effect extends MobEffect
{
    public AstralTravel_Effect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier)
    {

        if (!livingEntity.level().isClientSide() && livingEntity instanceof ServerPlayer player)
        {
            //Apply spectator mode once
                if(player.gameMode.getGameModeForPlayer() == GameType.SPECTATOR)
                {
                    MobEffectInstance effectInstance = player.getEffect(ModEffects.AstralTravel_Effect);
                    if (effectInstance == null) return false;

                    int duration = effectInstance.getDuration();

                   //If player is in spectator and no longer has effect.
                    if (duration == 1)
                    {
                        player.setGameMode(GameType.SURVIVAL);
                    }
                }

        }
        return true;

    }

    @Override
    public void onEffectStarted(LivingEntity livingEntity, int amplifier)
    {
        if (livingEntity instanceof ServerPlayer serverPlayer)
        {
            serverPlayer.setGameMode(GameType.SPECTATOR); //GameType.SPECTATOR
        }

    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier)
    {
        return true;
    }


}
