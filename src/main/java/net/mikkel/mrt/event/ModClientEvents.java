package net.mikkel.mrt.event;

import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.entity.ModEntities;
import net.mikkel.mrt.entity.client.DuraniumGolemRenderer;
import net.mikkel.mrt.entity.custom.DuraniumGolemEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = LembasBreadMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)

public class ModClientEvents
{
    @SubscribeEvent
    public static void registerrenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntities.DURANIUMGOLEM.get(), DuraniumGolemRenderer::new);
    }
}
