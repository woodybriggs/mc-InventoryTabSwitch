package com.woodybriggs.inventorytabswitch;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class UtilInventoryRotate {
    
    public static void rotateInventory(Player player) {
        int topRowSlotIndexStart = 0;
        int middleSlotIndexStart = 9;
        int bottomSlotIndexStart = 18;
        int hotBarSlotIndexStart = 27;

        for (int i = 0; i < 9; ++i)
        {
            ItemStack topRowItem = player.getInventory().getItem(topRowSlotIndexStart + i).copy();
            ItemStack middleItem = player.getInventory().getItem(middleSlotIndexStart + i).copy();
            ItemStack bottomItem = player.getInventory().getItem(bottomSlotIndexStart + i).copy();
            ItemStack hotbarItem = player.getInventory().getItem(hotBarSlotIndexStart + i).copy();

            player.getInventory().setItem(topRowSlotIndexStart + i, hotbarItem);
            player.getInventory().setItem(middleSlotIndexStart + i, topRowItem);
            player.getInventory().setItem(bottomSlotIndexStart + i, middleItem);
            player.getInventory().setItem(hotBarSlotIndexStart + i, bottomItem);
        }
    }
}
