package com.gamebuster19901.RDP.event.listeners;

import static com.gamebuster19901.RDP.event.KeyType.DOWN;
import static com.gamebuster19901.RDP.event.KeyType.LEFT;
import static com.gamebuster19901.RDP.event.KeyType.RIGHT;
import static com.gamebuster19901.RDP.event.KeyType.UP;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.HELD;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.PUSHED;

import com.gamebuster19901.RDP.event.KeyListener;
import com.gamebuster19901.RDP.event.KeyType;
import com.gamebuster19901.RDP.event.senders.KeyEvent;

import net.minecraft.client.Minecraft;

public class CameraMover implements KeyListener{
	
	public CameraMover(){
		register();
	}
	
	@Override
	public void onKeyEvent(KeyEvent e) {
		System.out.println(e.getKeyType());
		for(KeyType k : KeyType.values()){
			if (e.getEventType().equals(PUSHED)){
				if(e.getKeyType().equals(UP)){
					Minecraft.getMinecraft().player.rotationPitch -= 5;
				}
				else if(e.getKeyType().equals(DOWN)){
					Minecraft.getMinecraft().player.rotationPitch += 5;
				}
				else if (e.getKeyType().equals(RIGHT)){
					System.out.println(Minecraft.getMinecraft().player.rotationYaw);
					Minecraft.getMinecraft().player.rotationYaw += 5;
				}
				else if (e.getKeyType().equals(LEFT)){
					Minecraft.getMinecraft().player.rotationYaw -= 5;
				}
			}
			else if (e.getEventType().equals(HELD)){
				if(e.getTimeHeld() > 20){
					if(e.getKeyType().equals(UP)){
						Minecraft.getMinecraft().player.rotationPitch -= 0.1f;
					}
					else if(e.getKeyType().equals(DOWN)){
						Minecraft.getMinecraft().player.rotationPitch += 0.1f;
					}
					else if (e.getKeyType().equals(RIGHT)){
						Minecraft.getMinecraft().player.rotationYaw += 0.1f;
					}
					else if (e.getKeyType().equals(LEFT)){
						Minecraft.getMinecraft().player.rotationYaw -= 0.1f;
					}
				}
			}
		}
	}
}
