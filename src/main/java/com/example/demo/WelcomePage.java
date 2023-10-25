package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Add an event handler that switches to calendar
 * scene on circleButton click.
 * */

/**
 * Add an event handler that loads all previous
 * json files using the Load method; written by Tyler.
 * */
public class WelcomePage extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        VBox root = new VBox();

        Label myText = new Label("Study W/ Me");
//        myText.setAlignment(Pos.TOP_CENTER);
        myText.setFont(new Font("Elephant", 75));
        myText.setPadding(new Insets(0, 0, 130, 0));
        myText.setTextFill(Color.CORNFLOWERBLUE);

        double radius = 175;
        Button circleButton = new Button("GO");
        circleButton.setFont(new Font("Elephant", 45));
        circleButton.setTextFill(Color.CORNFLOWERBLUE);
        circleButton.setLayoutX(250);
        circleButton.setLayoutY(350);
        circleButton.setShape(new Circle(radius));
        circleButton.setBackground(Background.fill(Color.SKYBLUE));
        circleButton.setPrefSize(radius, radius);

        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.fill(Color.LIGHTCYAN));

        root.getChildren().addAll(myText, circleButton);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
