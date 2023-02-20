package com.woodybriggs.inventorytabswitch;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

public class RotateInventoryMessage {

    public RotateInventoryMessage() {

    }

    // create the constructor and store the structureType
    public RotateInventoryMessage(String structureType) {}

    // encode the message
    public static void encode(RotateInventoryMessage message, FriendlyByteBuf buffer) {
    }

    // decode the message
    public static RotateInventoryMessage decode(FriendlyByteBuf buffer) {
        return new RotateInventoryMessage();
    }

    public static void handle(RotateInventoryMessage message, Supplier<NetworkEvent.Context> ctxSupplier) {

        NetworkEvent.Context ctx = ctxSupplier.get();
        LogicalSide sideReceived = ctx.getDirection().getReceptionSide();
        ctx.setPacketHandled(true);

        if (sideReceived != LogicalSide.SERVER) {
            return;
        }

        ctx.enqueueWork(() -> {
            RotateInventoryMessage.processRotateInventoryMessage(ctx);
        });
    }

    public static void processRotateInventoryMessage(NetworkEvent.Context ctx) {
        UtilInventoryRotate.rotateInventory(ctx.getSender());
    }
}
