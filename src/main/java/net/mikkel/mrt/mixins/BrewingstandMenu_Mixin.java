package net.mikkel.mrt.mixins;

import net.mikkel.mrt.item.ModItems;
import net.minecraft.world.inventory.BrewingStandMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.inventory.BrewingStandMenu$FuelSlot")
public class BrewingstandMenu_Mixin
{
        @Inject(method = "mayPlaceItem", at = @At("HEAD"), cancellable = true)

        private static void allowCustomFuel(ItemStack stack, CallbackInfoReturnable<Boolean> cir)
        {
            if (stack.is(ModItems.ALCHEMISTCOAL))
            {
                cir.setReturnValue(true);
            }
        }
}
