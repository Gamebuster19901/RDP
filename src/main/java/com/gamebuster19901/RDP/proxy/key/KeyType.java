package com.gamebuster19901.RDP.proxy.key;

import org.lwjgl.input.Keyboard;

public enum KeyType {
	UP(Keyboard.KEY_UP), RIGHT(Keyboard.KEY_RIGHT), DOWN(Keyboard.KEY_DOWN), LEFT(Keyboard.KEY_LEFT);

	public int keyCode;
	private KeyType(int keyCode){
		this.keyCode = keyCode;
	}
	
	public static KeyType get(int keyCode){
		for(KeyType t : KeyType.values()){
			if (t.keyCode == keyCode){
				return t;
			}
		}
		throw new IllegalArgumentException();
	}
}
