package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;

public class ImportFileController {

    public Stage stage;
    FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("All PDFs", "*.pdf", "*.PDF");

//    public ImportFileController(Stage stage) {
//        this.stage = stage;
//        myCanvas1();
//        myCanvas2();
//    }


    @FXML
    private void myCanvas1(ActionEvent event) {
//        event.consume();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import File");

        fileChooser.getExtensionFilters().addAll(extensionFilter);

        File filePath = new File("C:/Documents");
        fileChooser.setInitialDirectory(filePath);
        File myFile = fileChooser.showOpenDialog(stage.getScene().getWindow());

        if (myFile != null){
            System.out.println("Opened file located at " + myFile.getPath());
        }
    }

    @FXML
    private void myCanvas2(ActionEvent event) {
//        event.consume();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(extensionFilter);
        File filePath = new File("C:/Documents");
        fileChooser.setInitialDirectory(filePath);

        File myFile = fileChooser.showSaveDialog(stage.getScene().getWindow());
        if (myFile != null){
            System.out.println("Saved file located at " + myFile.getPath());
        }
    }

}
