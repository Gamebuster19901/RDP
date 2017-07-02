package com.gamebuster19901.RDP.event;

import com.gamebuster19901.RDP.event.senders.KeyEvent;
import com.gamebuster19901.RDP.event.senders.KeyEventHandler;

public interface KeyListener {
	
	public void onKeyEvent(KeyEvent e);
	
	default void register(){
		KeyEventHandler.INSTANCE.register(this);
	}
	
	default void unregister(){
		KeyEventHandler.INSTANCE.unregister(this);
	}
}