package genetic.factories;

import static genetic.config.CommonConfig.MAX_CIRLCE_SIZE;
import static genetic.config.CommonConfig.MIN_CIRLCE_SIZE;
import static genetic.config.CommonConfig.PICTURE_HEIGHT;
import static genetic.config.CommonConfig.PICTURE_WIDHT;
import static genetic.utility.RandomUtility.randomGenerator;

import genetic.api.model.PaintingCircle;
import genetic.config.IndividualsConfig;

public class CircleFactory {

	public static PaintingCircle getRandomCircle() {
		PaintingCircle circle = new PaintingCircle();
		circle.setCenterX(getRandomXCoordinateInCanvas());
		circle.setCenterY(getRandomYCoordinateInCanvas());

		circle.setBrightness(getRandomRgbValue());

		circle.setRadius(getRandomRadius());
		circle.setOpacity(IndividualsConfig.DEFAULT_OPACITY);

		return circle;
	}

	private static int getRandomRgbValue() {
		return randomGenerator.nextInt(255);
	}

	private static int getRandomRadius() {
		return randomGenerator.nextInt(MAX_CIRLCE_SIZE - MIN_CIRLCE_SIZE) + MIN_CIRLCE_SIZE;
	}

	private static int getRandomXCoordinateInCanvas() {
		return randomGenerator.nextInt(PICTURE_WIDHT-MAX_CIRLCE_SIZE)+MAX_CIRLCE_SIZE;
	}

	private static int getRandomYCoordinateInCanvas() {
		return randomGenerator.nextInt(PICTURE_HEIGHT-MAX_CIRLCE_SIZE)+MAX_CIRLCE_SIZE;
	}

}
