package com.woodybriggs.inventorytabswitch;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InventoryTabSwitch.MODID)
public class InventoryTabSwitch {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "inventorytabswitch";

    public InventoryTabSwitch() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        SimpleChannelNetwork.init();
    }
}
