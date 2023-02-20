package com.woodybriggs.inventorytabswitch;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.util.Lazy;

@Mod.EventBusSubscriber(modid = InventoryTabSwitch.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class KeyMapper {

    public static final Lazy<KeyMapping> ROTATE_INVENTORY = Lazy
            .of(() -> new KeyMapping("key.inventorytabswitch.rotateinventory", InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_TAB, "key.categories.inventory"));

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(ROTATE_INVENTORY.get());
    }
}
