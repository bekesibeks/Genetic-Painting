package view.model;

import static genetic.config.CommonConfig.PICTURE_WIDHT;
import static javafx.scene.paint.Color.TRANSPARENT;
import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.shape.StrokeLineCap.ROUND;

import java.util.ArrayList;
import java.util.List;

import genetic.api.model.BrushPaintingIndividual;
import genetic.api.model.BrushPaintingCurve;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;

public class BrushPaintingView {

	private List<CubicCurve> curves = new ArrayList<>();

	public void buildModelFrom(BrushPaintingIndividual individual) {
		individual.getChromosomes().stream().map(chromosome -> (BrushPaintingCurve) chromosome)
				.forEach(curve -> curves.add(convertToCubicCurve(curve)));

	}

	private CubicCurve convertToCubicCurve(BrushPaintingCurve curve) {
		CubicCurve cubicCurve = new CubicCurve();

		cubicCurve.setStartX(curve.getStartX());
		cubicCurve.setStartY(curve.getStartY());
		cubicCurve.setEndX(curve.getEndX());
		cubicCurve.setEndY(curve.getEndY());
		cubicCurve.setControlX1(curve.getControlPoint1X());
		cubicCurve.setControlY1(curve.getControlPoint1Y());
		cubicCurve.setControlX2(curve.getControlPoint2X());
		cubicCurve.setControlY2(curve.getControlPoint2Y());

		cubicCurve.setOpacity(curve.getOpacity());

		cubicCurve.setStroke(Color.rgb(curve.getRed(), curve.getGreen(), curve.getBlue()));
		cubicCurve.setStrokeWidth(curve.getWidth());
		cubicCurve.setOpacity(curve.getOpacity());

		cubicCurve.setStrokeLineCap(ROUND);
		cubicCurve.setFill(TRANSPARENT);

		return cubicCurve;
	}

	public Group getModel() {
		Group group = new Group();
		group.getChildren().add(new Rectangle(PICTURE_WIDHT, PICTURE_WIDHT, WHITE));
		curves.stream().forEach(curve -> group.getChildren().add(curve));
		
		return group;
	}

}
