package com.gamebuster19901.RDP.event.senders;

import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.HELD;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.PUSHED;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.RELEASED;
import static com.gamebuster19901.RDP.proxy.ClientProxy.KEYBINDINGS;

import java.util.LinkedHashSet;

import com.gamebuster19901.RDP.event.KeyListener;
import com.gamebuster19901.RDP.event.KeyType;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KeyEventHandler {
	public static final KeyEventHandler INSTANCE = new KeyEventHandler();
	private static final LinkedHashSet<KeyListener> LISTENERS = new LinkedHashSet<KeyListener>();
	
	@SubscribeEvent
	void everyTick(TickEvent.RenderTickEvent e){
		for(AbsoluteKeyBinding kb : KEYBINDINGS){
			if(kb.isPressed()){
				if (kb.wasPressed == false){
					kb.wasPressed = true;
					new KeyEvent(PUSHED, KeyType.get(kb.getKeyCode()));
					kb.cyclesHeld++;
				}
				else if (kb.wasPressed == true){
					new KeyEvent(HELD, KeyType.get(kb.getKeyCode()));
					kb.cyclesHeld++;
				}
			}
			else{
				if(kb.wasPressed){
					kb.wasPressed = false;
					new KeyEvent(RELEASED, KeyType.get(kb.getKeyCode()));
					kb.cyclesHeld = 0;
				}
			}
		}
	}
	
	public final void register(KeyListener k){
		LISTENERS.add(k);
	}
	
	public final void unregister(KeyListener k){
		LISTENERS.remove(k);
	}
	
	public final void send(KeyEvent k){
		for (KeyListener l : LISTENERS){
			l.onKeyEvent(k);
		}
	}
}
