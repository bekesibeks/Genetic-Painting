package genetic.utility;

import java.util.Random;

public class RandomUtility {

	public static final Random randomGenerator = new Random();

	public static int getRandomNumberInRange(int currentCoordinate, int min, int max, int range) {
		int newCoordinate = currentCoordinate + randomGenerator.nextInt(range) - (range / 2);
		if (newCoordinate < min) {
			return min;
		}
		if (newCoordinate > max) {
			return max;
		}

		return newCoordinate;
	}

}
