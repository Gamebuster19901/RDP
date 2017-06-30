package com.gamebuster19901.RDP.event.listeners;

import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.HELD;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.PUSHED;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.RELEASED;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.DOWN;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.LEFT;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.RIGHT;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.UP;

import com.gamebuster19901.RDP.event.KeyListener;
import com.gamebuster19901.RDP.proxy.key.KeyEvent;

import net.minecraft.client.Minecraft;

public class CameraMover implements KeyListener{
	
	public CameraMover(){
		register();
	}
	
	@Override
	public void onKeyEvent(KeyEvent e) {
		if(e.getKeyType().equals(UP)){
			if(e.getEventType().equals(PUSHED) || e.getEventType().equals(HELD)){
				Minecraft.getMinecraft().player.cameraYaw++;
			}
		}
		
	}
	
}
