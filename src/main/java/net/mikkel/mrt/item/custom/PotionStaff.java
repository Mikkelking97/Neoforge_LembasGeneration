package net.mikkel.mrt.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

//Take inspiration from BOW (Rightclick -> Projectile) Thrown Potion/Snowball (Arch physics)
//Bundle (Inventory storage)
public class PotionStaff extends Item
{

    public PotionStaff(Properties properties)
    {
        super(properties);
    }

 @Override
    public InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();

        return super.useOn(context);
    }

}
