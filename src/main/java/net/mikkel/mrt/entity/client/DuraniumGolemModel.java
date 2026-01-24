package net.mikkel.mrt.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.entity.custom.DuraniumGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.IronGolemModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DuraniumGolemModel extends IronGolemModel<DuraniumGolemEntity>
{
    public DuraniumGolemModel(ModelPart root)
    {
        super(root);
    }
}
