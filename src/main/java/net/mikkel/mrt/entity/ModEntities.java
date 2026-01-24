package net.mikkel.mrt.entity;

import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.entity.custom.DuraniumGolemEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, LembasBreadMod.MODID);

    //Registering entity | Should probably be Monster instead of Creature Category
    public static final Supplier<EntityType<DuraniumGolemEntity>> DURANIUMGOLEM =
            ENTITY_TYPES.register("duraniumgolem", () -> EntityType.Builder.of(DuraniumGolemEntity::new, MobCategory.MISC)
                    .sized(1.4f, 2.7f).build("duraniumgolem"));

    //CopypasteGolemcode here and switch to other stuff.

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
