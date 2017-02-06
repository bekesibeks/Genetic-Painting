package genetic.utility;

import java.util.Random;

public class RandomUtility {

	public static final Random randomGenerator = new Random();

	public static int getRandomNumberInRange(int oldNumber, int min, int max, int range) {
		int newNumber = oldNumber + randomGenerator.nextInt(range) - (range / 2);
		if (newNumber < min) {
			return min;
		}
		if (newNumber > max) {
			return max;
		}

		return newNumber;
	}
}
