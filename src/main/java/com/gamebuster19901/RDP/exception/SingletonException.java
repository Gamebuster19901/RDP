package com.gamebuster19901.RDP.exception;

public class SingletonException extends RuntimeException {
	public SingletonException(Class c){
		super("Cannot instantiate more than one instance of " + c.getSimpleName());
	}
}
