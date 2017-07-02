package com.gamebuster19901.RDP.proxy.key;

import static com.gamebuster19901.RDP.proxy.key.ClientProxy.KEYBINDINGS;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.HELD;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.PUSHED;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.RELEASED;

import java.util.LinkedHashSet;

import com.gamebuster19901.RDP.event.KeyListener;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyEventHandler {
	public static final KeyEventHandler INSTANCE = new KeyEventHandler();
	private static final LinkedHashSet<KeyListener> LISTENERS = new LinkedHashSet<KeyListener>();
	
	public final void onKeyEvent(){
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
	
	@SubscribeEvent
	public void onInGameKey(InputEvent.KeyInputEvent e){
		KeyEventHandler.INSTANCE.onKeyEvent();
	}
	
	public final void register(KeyListener k){
		LISTENERS.add(k);
	}
	
	public final void send(KeyEvent k){
		for (KeyListener l : LISTENERS){
			l.onKeyEvent(k);
		}
	}
}
