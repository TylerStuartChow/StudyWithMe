package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.jfoenix.controls.JFXDrawer;

public class SideMenuControllerNEW implements Initializable {

    @FXML
    private Button btn_cal, btn_fil, btn_sea, btn_menu, settingsButton;

    @FXML
    private Pane myMenu;

    boolean extended = true;

    @FXML
    private Pane myArea;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // slides side menu in and out
        if (event.getSource() == btn_menu){
            myMenu.setTranslateX(-150);
            TranslateTransition transition = new TranslateTransition(Duration.millis(1000), myMenu);
            transition.setFromX(-150);
            transition.setToX(0);
            if (extended){
                transition.setRate(-1);
                transition.play();
                extended = false;
            }
            else{
                transition.setRate(1);
                transition.play();
                extended = true;
            }
        }
        // switch to calendar page
        else if (event.getSource() == btn_cal) {
            Parent fxml1 = FXMLLoader.load(getClass().getResource("PageView1.fxml"));
            myArea.getChildren().removeAll();
            myArea.getChildren().setAll(fxml1);
            // switch to files page
        } else if (event.getSource() == btn_fil) {
            Parent fxml2 = FXMLLoader.load(getClass().getResource("PageView2.fxml"));
            myArea.getChildren().removeAll();
            myArea.getChildren().setAll(fxml2);
        // switch to search page
        } else if (event.getSource() == btn_sea) {
            Parent fxml3 = FXMLLoader.load(getClass().getResource("PageView3.fxml"));
            myArea.getChildren().removeAll();
            myArea.getChildren().setAll(fxml3);
        }
        // switch to settings page
        else if (event.getSource() == settingsButton){
            Parent fxml4 = FXMLLoader.load(getClass().getResource("PageView4.fxml"));
            myArea.getChildren().removeAll();
            myArea.getChildren().setAll(fxml4);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Left blank intentionally
    }

}




