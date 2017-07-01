package com.gamebuster19901.RDP.proxy.key;

import org.lwjgl.input.Keyboard;

import com.gamebuster19901.RDP.proxy.CommonProxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.gamebuster19901.RDP.Main.MODID;

public class ClientProxy extends CommonProxy{
	static final AbsoluteKeyBinding[] KEYBINDINGS = new AbsoluteKeyBinding[]{
		new AbsoluteKeyBinding("key." + MODID + "up.description", Keyboard.KEY_UP, "key." + MODID + ".up"),
		new AbsoluteKeyBinding("key." + MODID + "right.description", Keyboard.KEY_RIGHT, "key." + MODID + ".right"),
		new AbsoluteKeyBinding("key." + MODID + "down.description", Keyboard.KEY_DOWN, "key." + MODID + ".down"),
		new AbsoluteKeyBinding("key." + MODID + "left.description", Keyboard.KEY_LEFT, "key." + MODID + ".left")
	};
	
    @Override
    public void preInit(FMLPreInitializationEvent e){
    	super.preInit(e);
    	MinecraftForge.EVENT_BUS.register(KeyEventHandler.INSTANCE);
    	for(KeyBinding kb : KEYBINDINGS){
    		//ClientRegistry.registerKeyBinding(kb);
    	}
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
