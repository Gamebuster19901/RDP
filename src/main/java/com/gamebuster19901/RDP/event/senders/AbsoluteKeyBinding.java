package com.gamebuster19901.RDP.event.senders;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;

/*
 * A keybinding that will always work even if the game is not the top level window, and no matter
 * what is happening in game.
 */

public class AbsoluteKeyBinding extends KeyBinding{
	boolean wasPressed = false;
	long cyclesHeld = 0;
		
	public AbsoluteKeyBinding(String description, int keyCode, String category) {
		super(description, keyCode, category);
	}

	@Override
	public boolean isPressed(){
		return isKeyDown(this.getKeyCode());
	}
		
	public static boolean isKeyDown(KeyBinding key){
		return isKeyDown(key.getKeyCode());
	}
	
	public static boolean isKeyDown(int key){;
		return Keyboard.isKeyDown(key);
	}
}
