package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SideMenuMainNEW extends Application {

    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SideMenuViewNEW.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Side Menu Title");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
