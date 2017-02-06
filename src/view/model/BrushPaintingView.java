package view.model;

import static genetic.config.CommonConfig.PICTURE_WIDHT;
import static javafx.scene.shape.StrokeLineCap.ROUND;

import java.util.ArrayList;
import java.util.List;

import genetic.api.model.BrushPaintingIndividual;
import genetic.api.model.PaintingCircle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BrushPaintingView {

	private List<Circle> circles = new ArrayList<>();

	public void buildModelFrom(BrushPaintingIndividual individual) {
		individual.getChromosomes().stream().map(chromosome -> (PaintingCircle) chromosome)
				.forEach(curve -> circles.add(convertToCircle(curve)));

	}

	private Circle convertToCircle(PaintingCircle circle) {
		Circle newCircle = new Circle();

		newCircle.setCenterX(circle.getCenterX());
		newCircle.setCenterY(circle.getCenterY());
		newCircle.setRadius(circle.getRadius());

		newCircle.setOpacity(circle.getOpacity());
		newCircle.setStrokeLineCap(ROUND);
		newCircle.setFill(Color.rgb(circle.getBrightness(), circle.getBrightness(), circle.getBrightness()));

		return newCircle;
	}

	public Group getModel() {
		Group group = new Group();
		group.getChildren().add(new Rectangle(PICTURE_WIDHT, PICTURE_WIDHT, Color.WHITE));
		circles.stream().forEach(curve -> group.getChildren().add(curve));

		return group;
	}

}
