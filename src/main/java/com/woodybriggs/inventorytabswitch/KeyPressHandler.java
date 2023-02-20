package com.woodybriggs.inventorytabswitch;

import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = InventoryTabSwitch.MODID, bus = Bus.FORGE)
public class KeyPressHandler {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) { // Only call code once as the tick event is called twice every tick
            while (KeyMapper.ROTATE_INVENTORY.get().consumeClick()) {
                SimpleChannelNetwork.CHANNEL.sendToServer(new RotateInventoryMessage());
            }
        }
    }
}
