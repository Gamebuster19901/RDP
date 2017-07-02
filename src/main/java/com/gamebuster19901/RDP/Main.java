package com.gamebuster19901.RDP;

import static com.gamebuster19901.RDP.Main.MODID;
import static com.gamebuster19901.RDP.Main.VERSION;

import com.gamebuster19901.RDP.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, version = VERSION)
public class Main {
    public static final String MODID = "rdp";
    public static final String VERSION = "0.0.0.0";
    @SidedProxy(clientSide = "com.gamebuster19901.RDP.proxy.ClientProxy", serverSide = "com.gamebuster19901.RDP.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
    	proxy.preInit(e);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
    	proxy.postInit(e);
    }
}
