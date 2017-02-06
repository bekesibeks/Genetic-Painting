package application;


import genetic.api.evolution.Generation;
import genetic.api.evolution.Individual;
import genetic.api.model.BrushPaintingGeneration;
import genetic.api.model.BrushPaintingIndividual;
import genetic.managerimpl.GeneticAlgorithmManagerImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.model.BrushPaintingView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setId("pane");
			Scene scene = new Scene(root, 800, 400);
			
			Generation generation = new BrushPaintingGeneration();
			GeneticAlgorithmManagerImpl manager = new GeneticAlgorithmManagerImpl(generation);
				
			final Timeline timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(150), event -> {
				manager.makeEvolutionStep();
				Individual fittestIndividual = manager.getFittestIndividual();
				BrushPaintingView view = new BrushPaintingView();
				view.buildModelFrom((BrushPaintingIndividual) fittestIndividual);
				Group model = view.getModel();
				root.getChildren().setAll(model);
			}));
			timeline.play();
			
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
