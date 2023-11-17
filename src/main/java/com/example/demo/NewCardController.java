package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.SaveState.Save;


public class NewCardController implements Initializable {

    @FXML
    private Button back_btn, add_card_btn;

    @FXML
    private TextField front, back;


    @FXML
    private Pane myPane;



    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        // takes you to back to main card view
        if (event.getSource() == back_btn){
            Parent fxml = FXMLLoader.load(getClass().getResource("TabsNEW.fxml"));
            Scene scene = new Scene(fxml);
            TabsMainNEW.getStage().setScene(scene);
//            myPane.getChildren().removeAll();
//            myPane.getChildren().setAll(fxml);
        }
    }

    @FXML
    private void handleAddCard(ActionEvent event) throws IOException {
        if (event.getSource() == add_card_btn){
            AddCueCard(front.getText(), back.getText());
        }
    }

    /***
     * creates a new cue card and stores it in an array list and json file
     * @param question the question on the cue card
     * @param answer the answer for the question
     * @return 0 on success, -1 on error, -2 for invalid input
     */
    private static int AddCueCard(String question, String answer) {
        if (question.isBlank() || answer.isBlank()) {//checking for invalid input
            System.out.println("to create a cue card, user needs to provide a question and answer");
            return -2;
        }

        CueCard newCard = new CueCard(question, answer);
        Subject.cueCardsList.add(newCard);
        Subject.practiceList.add(newCard);

        if (!Save(Subject.cardPath, Subject.cueCardsList)) {
            System.out.println("something went wrong with saving to " + Subject.cardPath);
            return -1;
        }

        Subject.updated = true;

        return 0;
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO
    }
}
