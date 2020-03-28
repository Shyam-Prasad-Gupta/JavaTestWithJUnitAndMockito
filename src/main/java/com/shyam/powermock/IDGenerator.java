package com.shyam.powermock;

public final class IDGenerator {

	private static int i = 0;

	public static int generateId() {
		return i++;
	}
}
