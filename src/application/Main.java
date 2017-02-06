package application;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import genetic.api.evolution.Generation;
import genetic.api.evolution.Individual;
import genetic.api.model.BrushPaintingGeneration;
import genetic.api.model.BrushPaintingIndividual;
import genetic.managerimpl.GeneticAlgorithmManagerImpl;
import genetic.utility.FitnessCalculator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.model.BrushPaintingView;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setId("pane");
			Scene scene = new Scene(root, 800, 400);

			final ImageView imv = new ImageView();
			final Image image2 = new Image(Main.class.getResourceAsStream("test_2.jpg"));
			imv.setImage(image2);
			imv.setTranslateX(400);
			imv.setTranslateY(20);
			root.getChildren().add(imv);

			Generation generation = new BrushPaintingGeneration();
			GeneticAlgorithmManagerImpl manager = new GeneticAlgorithmManagerImpl(generation);

			final Timeline timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);

			Group wrappedGroup = new Group();
			wrappedGroup.setTranslateX(20);
			wrappedGroup.setTranslateY(20);

			root.getChildren().add(wrappedGroup);

			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), event -> {
				manager.makeEvolutionStep();
				Individual fittestIndividual = manager.getFittestIndividual();

				BrushPaintingView view = new BrushPaintingView();
				view.buildModelFrom((BrushPaintingIndividual) fittestIndividual);
					
				
				Group model = view.getModel();
				writeSnapshotImage(root.snapshot(null , new WritableImage(200, 200)),"output.jpg");
				wrappedGroup.getChildren().setAll(model);
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

	public static void writeSnapshotImage(WritableImage snapshot, String title){
		File outFile = new File("out_" + title + ".png");
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", outFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
