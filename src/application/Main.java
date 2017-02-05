package application;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			Line line = new Line(30, 30, 200, 200);
			line.setStroke(Color.rgb(30, 30, 30));
			line.setOpacity(0.7);

			CubicCurve curve = new CubicCurve();
			curve.setStartX(100);
			curve.setStartY(100);
			curve.setControlX1(150);
			curve.setControlY1(50);
			curve.setControlX2(250);
			curve.setControlY2(150);
			curve.setEndX(300);
			curve.setEndY(100);
//			curve.setStroke
			curve.setStroke(Color.rgb(43, 43, 211));
			curve.setStrokeWidth(6);
			curve.setStrokeLineCap(StrokeLineCap.ROUND);
			curve.setOpacity(0.7);
			curve.setFill(Color.TRANSPARENT);

			root.getChildren().add(curve);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
