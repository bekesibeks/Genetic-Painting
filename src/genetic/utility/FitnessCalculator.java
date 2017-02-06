package genetic.utility;

import javafx.scene.image.WritableImage;

import static genetic.config.CommonConfig.PICTURE_HEIGHT;
import static genetic.config.CommonConfig.PICTURE_WIDHT;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class FitnessCalculator {

	public static WritableImage source;

	public FitnessCalculator() {
	}

	public static WritableImage getSourceImage(int dimensionX, int dimensionY) {
		final Image image = new Image("file:test.png");
		WritableImage writableImage = new WritableImage(image.getPixelReader(), dimensionX, dimensionY);
		return writableImage;
	}

	public static long calculateRgbDifference(Group model) {
		return calculateRgbDifference(getSnapshot(model));
	}

	/*
	 * RGB difference between the source image and the painted image. Basically
	 * equivalent with the fitness of each individual.
	 */
	public static long calculateRgbDifference(WritableImage image) {
		if (source == null) {
			source = getSourceImage(PICTURE_WIDHT, PICTURE_HEIGHT);
		}
		double sum = 0;
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				Color colorFromPaintedImage = image.getPixelReader().getColor(i, j);
				Color colorFromSourceImage = source.getPixelReader().getColor(i, j);

				double blueDifference = Math.abs(colorFromPaintedImage.getBlue() - colorFromSourceImage.getBlue());
				double redDifference = Math.abs(colorFromPaintedImage.getRed() - colorFromSourceImage.getRed());
				double greenDifference = Math.abs(colorFromPaintedImage.getGreen() - colorFromSourceImage.getGreen());

				sum += (blueDifference + redDifference + greenDifference)
						* (blueDifference + redDifference + greenDifference);
			}
		}

		return (long) ((1d - (double) (sum / (PICTURE_WIDHT * PICTURE_HEIGHT * 9))) * 10000000);
	}

	private static WritableImage getSnapshot(Node root) {
		WritableImage writableImage = new WritableImage(PICTURE_WIDHT, PICTURE_HEIGHT);
		WritableImage snapshot = root.snapshot(null, writableImage);
		ImageView imageView = new ImageView(snapshot);
		imageView.setFitWidth(PICTURE_WIDHT);
		imageView.setFitHeight(PICTURE_HEIGHT);
		SnapshotParameters params = new SnapshotParameters();
		WritableImage snapshot2 = imageView.snapshot(params, null);
		return snapshot2;
	}

}
