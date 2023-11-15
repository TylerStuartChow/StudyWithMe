package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TabsMainNEW extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TabsNEW.fxml"));
        Parent root = loader.load();
        ImportFileControllerNEW importFileControllerNEW = loader.getController();
        importFileControllerNEW.myHostServices(getHostServices());

        stage.setTitle("PDF importer");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
