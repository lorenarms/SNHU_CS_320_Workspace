package com.project.one.all.services;


import java.util.Random;

public class UniqueIDGenerator {

	// change this to change the size of the generated ID
	static final int ID_SIZE = 10; 
	private static String[] _pool;
	
	// create's a pool of character's to pull from when generating a unique ID
	// does this once
	public static void generatePool(){
		_pool = new String[62];
		int index = 0;
		for (int i = 48; i < 58; i++) {
			_pool[index] = Character.toString((char) i);
			index++;
		}
		for (int i = 65; i < 91; i++) {
			_pool[index] = Character.toString((char) i);
			index++;
		}
		for (int i = 97; i < 123; i++) {
			_pool[index] = Character.toString((char) i);
			index++;
		}
		// all valid ASCII characters
		
	}
		
	public static String generateUniqueID(){
		if (_pool == null) {
			generatePool();
		}
		// pulls from '_pool' to generate unique ID
        String s = "";
        Random rnd = new Random();
        for (int i = 0; i < ID_SIZE; i++) {
        	s = s + _pool[rnd.nextInt(_pool.length)];
        }
        return s;
	}
	
	// use this to determine if hashmap is full yet
	// this is unlikely to happen with an ID_SIZE of 8 or greater
	public static double getMaxEntries() {
		return Math.pow(_pool.length, ID_SIZE);
	}
	
}
