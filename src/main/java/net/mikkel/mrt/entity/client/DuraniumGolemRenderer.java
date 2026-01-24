package net.mikkel.mrt.entity.client;

import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.entity.custom.DuraniumGolemEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DuraniumGolemRenderer extends MobRenderer<DuraniumGolemEntity, DuraniumGolemModel>
{
    public DuraniumGolemRenderer(EntityRendererProvider.Context p_174188_)
    {
        super(p_174188_, new DuraniumGolemModel(p_174188_.bakeLayer(ModelLayers.IRON_GOLEM)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(DuraniumGolemEntity duraniumGolemEntity)
    {
        return ResourceLocation.fromNamespaceAndPath(LembasBreadMod.MODID, "textures/entity/duraniumgolem_texture.png");
    }
}
