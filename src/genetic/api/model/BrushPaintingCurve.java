package genetic.api.model;

import static genetic.config.CommonConfig.COLOR_CHANGE_AMOUNT;
import static genetic.config.CommonConfig.PICTURE_HEIGHT;
import static genetic.config.CommonConfig.PICTURE_WIDHT;
import static genetic.config.CommonConfig.POSITION_CHANGE_AMOUNT;
import static genetic.config.IndividualsConfig.MAX_WIDTH_OF_CURVES;
import static genetic.config.IndividualsConfig.MIN_WIDTH_OF_CURVES;
import static genetic.utility.RandomUtility.getRandomNumberInRange;
import static genetic.utility.RandomUtility.randomGenerator;

import genetic.api.evolution.Chromosome;

public class BrushPaintingCurve implements Chromosome {

	private int startX;
	private int startY;

	private int endX;
	private int endY;

	private int controlPoint1X;
	private int controlPoint1Y;

	private int controlPoint2X;
	private int controlPoint2Y;

	private int red;
	private int green;
	private int blue;

	private int width;
	private double opacity;
	
	public BrushPaintingCurve() {
	}
	
	public BrushPaintingCurve(BrushPaintingCurve source) {
		startX=source.startX;
		startY=source.startY;
		endX=source.endX;
		endY=source.endY;
		controlPoint1X=source.controlPoint1X;
		controlPoint1Y=source.controlPoint1Y;
		controlPoint2X=source.controlPoint2X;
		controlPoint2Y=source.controlPoint2Y;
		red=source.red;
		green=source.green;
		blue=source.blue;
		width=source.width;
		opacity=source.opacity;
	}
	
	@Override
	public void mutate() {
		
		if (randomGenerator.nextBoolean()) {
			startX = getRandomNumberInRange(startX, 0, PICTURE_WIDHT, POSITION_CHANGE_AMOUNT);
		}

		if (randomGenerator.nextBoolean()) {
			startY = getRandomNumberInRange(startY, 0, PICTURE_HEIGHT, POSITION_CHANGE_AMOUNT);
		}

		if (randomGenerator.nextBoolean()) {
			endX = getRandomNumberInRange(endX, 0, PICTURE_WIDHT, POSITION_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			endY = getRandomNumberInRange(endY, 0, PICTURE_HEIGHT, POSITION_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			controlPoint1X = getRandomNumberInRange(controlPoint1X, 0, PICTURE_WIDHT, POSITION_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			controlPoint1Y = getRandomNumberInRange(controlPoint1Y, 0, PICTURE_HEIGHT, POSITION_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			controlPoint2X = getRandomNumberInRange(controlPoint2X, 0, PICTURE_WIDHT, POSITION_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			controlPoint2Y = getRandomNumberInRange(controlPoint2Y, 0, PICTURE_HEIGHT, POSITION_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			red = getRandomNumberInRange(red, 0, 255, COLOR_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			green = getRandomNumberInRange(green, 0, 255, COLOR_CHANGE_AMOUNT);
		}
		if (randomGenerator.nextBoolean()) {
			blue = getRandomNumberInRange(blue, 0, 255, COLOR_CHANGE_AMOUNT);
		}

		if (randomGenerator.nextBoolean()) {
			width = getRandomNumberInRange(width, MIN_WIDTH_OF_CURVES, MAX_WIDTH_OF_CURVES, 4);
		}

	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public int getControlPoint1X() {
		return controlPoint1X;
	}

	public void setControlPoint1X(int controlPoint1X) {
		this.controlPoint1X = controlPoint1X;
	}

	public int getControlPoint1Y() {
		return controlPoint1Y;
	}

	public void setControlPoint1Y(int controlPoint1Y) {
		this.controlPoint1Y = controlPoint1Y;
	}

	public int getControlPoint2X() {
		return controlPoint2X;
	}

	public void setControlPoint2X(int controlPoint2X) {
		this.controlPoint2X = controlPoint2X;
	}

	public int getControlPoint2Y() {
		return controlPoint2Y;
	}

	public void setControlPoint2Y(int controlPoint2Y) {
		this.controlPoint2Y = controlPoint2Y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getOpacity() {
		return opacity;
	}

	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

}
