package com.woodybriggs.inventorytabswitch;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class SimpleChannelNetwork {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(InventoryTabSwitch.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public static void init() {
        CHANNEL.registerMessage(0, RotateInventoryMessage.class, RotateInventoryMessage::encode,
                RotateInventoryMessage::decode, RotateInventoryMessage::handle);
    }
}
