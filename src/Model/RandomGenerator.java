package model;

import java.util.Random;

public class RandomGenerator extends Random {

	/**
	 * Public singleton random number generator class with optional seed
	 */
	private static final long serialVersionUID = 6557344800504980326L;
	private static RandomGenerator singleton = null;
	private long seed;
	
	public static RandomGenerator getInstance() {
		if (singleton == null){
			singleton = new RandomGenerator();
		}
		return singleton;
	}
	
	public long getSeed() {
		return seed;
	}

	public void setSeed(long seed) {
		this.seed = seed;
	}
}
