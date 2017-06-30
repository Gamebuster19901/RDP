package com.gamebuster19901.RDP.proxy.key;

import java.util.LinkedHashSet;

import com.gamebuster19901.RDP.event.KeyListener;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import static com.gamebuster19901.RDP.proxy.key.ClientProxy.KEYBINDINGS;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.HELD;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.PUSHED;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.EventType.RELEASED;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.DOWN;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.LEFT;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.RIGHT;
import static com.gamebuster19901.RDP.proxy.key.KeyEvent.KeyType.UP;

public class KeyEventHandler {
	public static final KeyEventHandler INSTANCE = new KeyEventHandler();
	private static final LinkedHashSet<KeyListener> LISTENERS = new LinkedHashSet<KeyListener>();
	
	public final void onKeyEvent(){
		if(ClientProxy.KEYBINDINGS[0].isPressed()){
			if(KEYBINDINGS[0].wasPressed == false){
				KEYBINDINGS[0].wasPressed = true;
				new KeyEvent(PUSHED, UP);
				KEYBINDINGS[0].cyclesHeld++;
			}
			else if (KEYBINDINGS[0].wasPressed == true){
				new KeyEvent(HELD, UP);
				KEYBINDINGS[0].cyclesHeld++;
			}
		}
		else if(!(ClientProxy.KEYBINDINGS[0].isPressed())){
			if(KEYBINDINGS[0].wasPressed){
				KEYBINDINGS[0].wasPressed = false;
				new KeyEvent(RELEASED, UP);
				KEYBINDINGS[0].cyclesHeld = 0;
			}
		}
		
		if(ClientProxy.KEYBINDINGS[1].isPressed()){
			if(KEYBINDINGS[1].wasPressed == false){
				KEYBINDINGS[1].wasPressed = true;
				new KeyEvent(PUSHED, RIGHT);
				KEYBINDINGS[1].cyclesHeld++;
			}
			else if (KEYBINDINGS[1].wasPressed == true){
				new KeyEvent(HELD, RIGHT);
				KEYBINDINGS[1].cyclesHeld++;
			}
		}
		else if(!(ClientProxy.KEYBINDINGS[1].isPressed())){
			if(KEYBINDINGS[1].wasPressed){
				KEYBINDINGS[1].wasPressed = false;
				new KeyEvent(RELEASED, RIGHT);
				KEYBINDINGS[1].cyclesHeld = 0;
			}
		}
		
		if(ClientProxy.KEYBINDINGS[2].isPressed()){
			if(KEYBINDINGS[2].wasPressed == false){
				KEYBINDINGS[2].wasPressed = true;
				new KeyEvent(PUSHED, DOWN);
				KEYBINDINGS[2].cyclesHeld++;
			}
			else if (KEYBINDINGS[2].wasPressed == true){
				new KeyEvent(HELD, DOWN);
				KEYBINDINGS[2].cyclesHeld++;
			}
		}
		else if(!(ClientProxy.KEYBINDINGS[2].isPressed())){
			if(KEYBINDINGS[2].wasPressed){
				KEYBINDINGS[2].wasPressed = false;
				new KeyEvent(RELEASED, DOWN);
				KEYBINDINGS[2].cyclesHeld = 0;
			}
		}
		
		if(ClientProxy.KEYBINDINGS[3].isPressed()){
			if(KEYBINDINGS[3].wasPressed == false){
				KEYBINDINGS[3].wasPressed = true;
				new KeyEvent(PUSHED, LEFT);
				KEYBINDINGS[3].cyclesHeld++;
			}
			else if (KEYBINDINGS[3].wasPressed == true){
				new KeyEvent(HELD, DOWN);
				KEYBINDINGS[3].cyclesHeld++;
			}
		}
		else if(!(ClientProxy.KEYBINDINGS[3].isPressed())){
			if(KEYBINDINGS[3].wasPressed){
				KEYBINDINGS[3].wasPressed = false;
				new KeyEvent(RELEASED, UP);
				KEYBINDINGS[3].cyclesHeld = 0;
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
