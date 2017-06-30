package com.gamebuster19901.RDP.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy{
    @EventHandler
    @Override
    public void preInit(FMLPreInitializationEvent e){
    	super.preInit(e);
    }
    
    @EventHandler
    @Override
    public void init(FMLInitializationEvent e){
    	super.init(e);
    }
    
    @EventHandler
    @Override
    public void postInit(FMLPostInitializationEvent e){
    	super.postInit(e);
    }
}
