package sample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import javax.swing.filechooser.FileView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ImportFileControllerNEW {

    ExtensionFilter extensionFilter = new ExtensionFilter("All PDFs", "*.pdf", "*.PDF");
    HostServices hostServices;

    @FXML
    private Button btn_importFile, btn_openFile;

    @FXML
    // Open our file when necessary
    public void myHostServices(HostServices hostServices){
        this.hostServices = hostServices;
    }

    // import and save file to our folder
    @FXML
    public void handleImport(ActionEvent event) throws IOException {
        if (event.getSource() == btn_importFile){
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(extensionFilter);
            fileChooser.setTitle("Import File");
//            fileChooser.setInitialDirectory(new File("C:/Files"));
            Stage stage = (Stage) btn_importFile.getScene().getWindow();
            File myFile = fileChooser.showSaveDialog(stage);
            if (myFile != null){
                // copies file from chosen path to our myFiles package
                File source = new File(myFile.getPath());
                boolean success = source.renameTo(new File("C:\\Users\\sakha\\IdeaProjects\\ImportPDF\\src\\myFiles\\java.pdf"));
                // prints message that file was imported and saved
                System.out.println("Operation success " + success);
            }
            else{
                System.out.println("No file imported");
            }
        }
    }

    // C:\Users\sakha\IdeaProjects\ImportPDF\src\myFiles



    // open files in our folder
    @FXML
    public void handleOpen(ActionEvent event) {
        if (event.getSource() == btn_openFile){
            // Choose file to be opened
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(extensionFilter);
            fileChooser.setTitle("Open File");
            // This part is hardcoded to a folder located in IdeaProjects, Your Project, src, Specific Package Name
            fileChooser.setInitialDirectory(new File("C:\\Users\\sakha\\IdeaProjects\\ImportPDF\\src\\myFiles"));
            // Show open file dialog
            Stage stage = (Stage) btn_openFile.getScene().getWindow();
            File myFile = fileChooser.showOpenDialog(stage);
//            // Open the PDF
//            HostServices hostServices = getHostServices();
            hostServices.showDocument(myFile.getAbsolutePath());
            // Print message in console that file has or hasn't been opened
            if (myFile != null){
                System.out.println("File at location " + myFile.getPath() + " opened");
            }
            else{
                System.out.println("No file opened");
            }
        }
    }
























































//    public Stage stage;
//    private Pane myPane;
//    public ActionEvent event;


//    public ImportFileViewController(Stage stage, ActionEvent event){
//        this.stage = stage;
//        handleImportButtonAction(event);
//        handleOpenButtonAction(event);
//    }









//
//    @FXML
//    private void handleImportButtonAction(ActionEvent event) {
//        if (event.getSource() == btn_importFile) {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Import PDF");
//            fileChooser.getExtensionFilters().add(extensionFilter);
//
//            // we're choosing multiple files
//            List<File> myFiles = fileChooser.showOpenMultipleDialog(null);
//
//            // print out the path of all the chosen files
//            for (File file: myFiles){
//                System.out.println(file.getAbsolutePath());
//
//                for (Label label: labels){
//                    label.setText(file.getAbsolutePath());
//                }
//            }
//
//            // default file path
//            File filePath = new File("C:/Downloads");
//            fileChooser.setInitialDirectory(filePath);
//
//            // print message that file path has been chosen
////            File myFile = fileChooser.showOpenDialog(stage.getScene().getWindow());
////            if (myFile != null) {
////                System.out.println("Opened file located at " + myFile.getPath());
////            }
//        }
//    }
//
//
//    @FXML
//    private void handleSaveButtonAction(ActionEvent event) {
//        if (event.getSource() == btn_saveFile) {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Save PDF");
//            fileChooser.getExtensionFilters().add(extensionFilter);
//
//            // default file path
//            File filePath = new File("C:/Downloads");
//            fileChooser.setInitialDirectory(filePath);
//
//            // print message that file path has been saved
//            File myFile = fileChooser.showSaveDialog(stage.getScene().getWindow());
//            if (myFile != null) {
//                System.out.println("Opened file located at " + myFile.getPath());
//            }
//        }
//    }
//
//    public void initialize(URL url, ResourceBundle resourceBundle){
//        allLabels = new ArrayList<>();
//        allLabels.add("*.pdf");
//        allLabels.add("*.PDF");
//    }


}
