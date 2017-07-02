package com.gamebuster19901.RDP.event.senders;

import static com.gamebuster19901.RDP.event.KeyType.DOWN;
import static com.gamebuster19901.RDP.event.KeyType.LEFT;
import static com.gamebuster19901.RDP.event.KeyType.RIGHT;
import static com.gamebuster19901.RDP.event.KeyType.UP;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.HELD;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.PUSHED;
import static com.gamebuster19901.RDP.event.senders.KeyEvent.EventType.RELEASED;

import com.gamebuster19901.RDP.event.KeyType;
import com.gamebuster19901.RDP.proxy.ClientProxy;


public final class KeyEvent {
	public static final KeyEvent REGISTER = new KeyEvent(RELEASED, UP);

	private EventType type;
	private KeyType key;

	KeyEvent(EventType t, KeyType k) {
		type = t;
		key = k;
		if (t == PUSHED) {
			System.out.println("PUSHED");
		}
		if (t == HELD) {
			System.out.println("HELD");
		}
		if (t == RELEASED) {
			System.out.println("RELEASED");
		}
		KeyEventHandler.INSTANCE.send(this);
	}

	public final EventType getEventType() {
		return EventType.get(type);
	}

	public final KeyType getKeyType() {
		return key;
	}
	
	public final int getKeyCode(){
		return key.keyCode;
	}

	public final long getTimeHeld() {
		if (this.key == UP) {
			return ClientProxy.KEYBINDINGS[0].cyclesHeld;
		} else if (this.key == RIGHT) {
			return ClientProxy.KEYBINDINGS[1].cyclesHeld;
		} else if (this.key == DOWN) {
			return ClientProxy.KEYBINDINGS[2].cyclesHeld;
		} else if (this.key == LEFT) {
			return ClientProxy.KEYBINDINGS[3].cyclesHeld;
		}
		throw new IllegalStateException();
	}

	public static enum EventType {
		PUSHED, HELD, RELEASED;

		public static EventType get(EventType e) {
			if (e == PUSHED) {
				return PUSHED;
			}
			if (e == HELD) {
				return HELD;
			}
			if (e == RELEASED) {
				return RELEASED;
			}
			throw new IllegalStateException();
		}
	}
}
