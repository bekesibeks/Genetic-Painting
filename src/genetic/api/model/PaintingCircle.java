package genetic.api.model;

import static genetic.config.CommonConfig.COLOR_CHANGE_AMOUNT;
import static genetic.config.CommonConfig.MAX_CIRLCE_SIZE;
import static genetic.config.CommonConfig.MIN_CIRLCE_SIZE;
import static genetic.config.CommonConfig.PICTURE_HEIGHT;
import static genetic.config.CommonConfig.PICTURE_WIDHT;
import static genetic.config.CommonConfig.POSITION_CHANGE_AMOUNT;
import static genetic.utility.RandomUtility.getRandomNumberInRange;
import static genetic.utility.RandomUtility.randomGenerator;

import genetic.api.evolution.Chromosome;
import genetic.config.CommonConfig;

public class PaintingCircle implements Chromosome {

	private int centerX;
	private int centerY;

	private int radius;

	private int brightness;

	private double opacity;

	public PaintingCircle() {
	}

	public PaintingCircle(PaintingCircle source) {
		this.centerX = source.centerX;
		this.centerY = source.centerY;
		this.radius = source.radius;
		this.brightness = source.brightness;

		this.opacity = source.opacity;
	}

	@Override
	public void mutate() {
		if (randomGenerator.nextBoolean()) {
			centerX = getRandomNumberInRange(centerX, 0 + radius, PICTURE_WIDHT, POSITION_CHANGE_AMOUNT);
		}

		if (randomGenerator.nextBoolean()) {
			centerY = getRandomNumberInRange(centerY, 0 + radius, PICTURE_HEIGHT, POSITION_CHANGE_AMOUNT);
		}

		if (randomGenerator.nextBoolean()) {
			radius = getRandomNumberInRange(radius, MIN_CIRLCE_SIZE, MAX_CIRLCE_SIZE, 10);
		}

		if (randomGenerator.nextBoolean()) {
			brightness = getRandomNumberInRange(brightness, 0, 255, COLOR_CHANGE_AMOUNT);
		}
		
		if (randomGenerator.nextBoolean()) {
			double newOpacity = opacity+((Math.random()-0.5)/2.0);
			if(newOpacity<0) newOpacity = 0;
			if(newOpacity>1) newOpacity = 1;
			opacity = newOpacity;
		}

	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public double getOpacity() {
		return opacity;
	}

	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}
}
