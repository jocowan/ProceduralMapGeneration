package model;

import java.util.Random;

public class RandomGenerator extends Random {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7657596313265065119L;
	/**
	 * Public singleton random number generator class with optional seed
	 */
	
	private static Random singleton = null;
	private long seed;
	
	public static Random getInstance() {
		if (singleton == null){
			singleton = new Random();
		}
		return singleton;
	}
	
	public long getSeed() {
		return seed;
	}

	@Override
	public void setSeed(long seed) {
		this.seed = seed;
		RandomGenerator.singleton.setSeed(seed);
	}
}
