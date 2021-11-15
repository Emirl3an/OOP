package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    String currentLight = "GREEN";

    @Override
    public void start(Stage primaryStage) {

        String COLOR_GREEN_DARK = "#008000";
        String COLOR_GREEN = "47C746";
        String COLOR_YELLOW_DARK = "CA7602";
        String COLOR_YELLOW = "FFFF40";
        String COLOR_RED_DARK = "A30504";
        String COLOR_RED = "FF0000";

        Circle red = new Circle(50, Color.valueOf(COLOR_RED_DARK));
        Circle green = new Circle(50, Color.valueOf(COLOR_GREEN_DARK));
        Circle yellow = new Circle(50, Color.valueOf(COLOR_YELLOW_DARK));

        VBox trafficLight = new VBox(red, yellow, green);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
        switch (currentLight) {
            case "GREEN":
                red.setFill(Color.valueOf(COLOR_RED_DARK));
                green.setFill(Color.valueOf(COLOR_GREEN));
                currentLight = "YELLOW";
                break;
            case "RED":
                yellow.setFill(Color.valueOf(COLOR_YELLOW_DARK));
                red.setFill(Color.valueOf(COLOR_RED));
                currentLight = "GREEN";
                break;
            case "YELLOW":
                green.setFill(Color.valueOf(COLOR_GREEN_DARK));
                yellow.setFill(Color.valueOf(COLOR_YELLOW));
                currentLight = "RED";
                break;
        }

        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        VBox root = new VBox(new StackPane(trafficLight));
        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Traffic Light Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}