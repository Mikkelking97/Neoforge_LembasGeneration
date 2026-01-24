package net.mikkel.mrt.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.mikkel.mrt.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandBlockEntity.class)
public abstract class Brewingstand_Mixin
{
    @Shadow int fuel;

    @Inject(method = "canPlaceItem", at = @At("HEAD"), cancellable = true)

    private void allowCustomFuel(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir)
    {
        if (slot == 4 && stack.is(ModItems.ALCHEMISTCOAL))
        {
            cir.setReturnValue(true);
        }
    }


    @Inject(method = "serverTick", at = @At("HEAD"), cancellable = true)

    private static void allowcustomfuel1(Level level, BlockPos pos, BlockState state, BrewingStandBlockEntity blockEntity, CallbackInfo ci)
    {
        ItemStack itemstack = (ItemStack)blockEntity.getItem(4);
        if (((Brewingstand_Mixin)(Object)blockEntity).fuel +2 <= 20 && itemstack.is(ModItems.ALCHEMISTCOAL))
        {
            ((Brewingstand_Mixin)(Object)blockEntity).fuel += 2;
            itemstack.shrink(1);
            setChanged1(level, pos, state);
        }
    }

    @Unique
    private static void setChanged1(Level level, BlockPos pos, BlockState state)
    {
        level.blockEntityChanged(pos);
        if (!state.isAir())
        {
            level.updateNeighbourForOutputSignal(pos, state.getBlock());
        }

    }
}

