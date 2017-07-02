package com.gamebuster19901.RDP.event;

import com.gamebuster19901.RDP.proxy.key.KeyEvent;
import com.gamebuster19901.RDP.proxy.key.KeyEventHandler;

public interface KeyListener {
	public void onKeyEvent(KeyEvent e);
	
	default void register(){
		KeyEventHandler.INSTANCE.register(this);
	}
}