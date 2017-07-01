package com.gamebuster19901.RDP.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy{
    @Override
    public void preInit(FMLPreInitializationEvent e){
    	super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e){
    	super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e){
    	super.postInit(e);
    }
}
