package genetic.factories;

import static genetic.config.CommonConfig.PICTURE_HEIGHT;
import static genetic.config.CommonConfig.PICTURE_WIDHT;
import static genetic.config.IndividualsConfig.DEFAULT_OPACITY;
import static genetic.config.IndividualsConfig.MAX_WIDTH_OF_CURVES;
import static genetic.config.IndividualsConfig.MIN_WIDTH_OF_CURVES;
import static genetic.utility.RandomUtility.randomGenerator;


import genetic.api.model.BrushPaintingCurve;

public class CurveFactory {


	public static BrushPaintingCurve getRandomCurve() {
		BrushPaintingCurve curve = new BrushPaintingCurve();
		curve.setStartX(getRandomXCoordinateInCanvas());
		curve.setStartY(getRandomYCoordinateInCanvas());
		curve.setControlPoint1X(getRandomXCoordinateInCanvas());
		curve.setControlPoint1Y(getRandomYCoordinateInCanvas());
		curve.setControlPoint2X(getRandomXCoordinateInCanvas());
		curve.setControlPoint2Y(getRandomYCoordinateInCanvas());
		curve.setEndX(getRandomXCoordinateInCanvas());
		curve.setEndY(getRandomYCoordinateInCanvas());

		curve.setRed(getRandomRgbValue());
		curve.setGreen(getRandomRgbValue());
		curve.setBlue(getRandomRgbValue());

		curve.setWidth(getRandomWidth());
		curve.setOpacity(DEFAULT_OPACITY);

		return curve;
	}

	private static int getRandomRgbValue() {
		return randomGenerator.nextInt(255);
	}

	private static int getRandomWidth() {
		return randomGenerator.nextInt(MAX_WIDTH_OF_CURVES - MIN_WIDTH_OF_CURVES) + MIN_WIDTH_OF_CURVES;
	}

	private static int getRandomXCoordinateInCanvas() {
		return randomGenerator.nextInt(PICTURE_WIDHT);
	}

	private static int getRandomYCoordinateInCanvas() {
		return randomGenerator.nextInt(PICTURE_HEIGHT);
	}

}
