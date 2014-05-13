package Model;

import java.util.Random;

public class RandomGenerator extends Random {
	private static RandomGenerator singleton = null;
	private long seed;
	
	public static RandomGenerator getInstance() {
		if (singleton == null){
			singleton = new RandomGenerator();
		}
		return singleton;
	}
}
