package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class StudyCardsController {

    @FXML
    private Button shuffle_btn, prev_card_btn, next_card_btn;

    @FXML
    private Button flip_btn, back_btn;

    @FXML
    private Label front_lbl, back_lbl;


    // goes back to original tabs view
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

    // Tyler please do this

//    @FXML
//    private void handleFlip(ActionEvent event){
//        if (event.getSource() == flip_btn){
//            if (front_lbl.isVisible()){
//                front_lbl.setVisible(false);
//                back_lbl.setVisible(true);
//            }
//            else if (back_lbl.isVisible()){
//                front_lbl.setVisible(true);
//                back_lbl.setVisible(false);
//            }
//        }
//    }



    @FXML
    private void handleShuffleCard(ActionEvent event) throws IOException {
        if (event.getSource() == shuffle_btn){
            RandomizeCards();
        }
    }


    /***
     * randomizes the order of the cue cards for study mode
     */
    public void RandomizeCards() {
        if (Subject.cueCardsList.size() <= 1) {
            System.out.println("Not enough cards to randomize");
            return;
        }

        //making sure that practice list is up to date
        if (Subject.updated) {
            Subject.practiceList.clear();
            Subject.practiceList.addAll(Subject.cueCardsList);

            Subject.updated = false;
        }


        ArrayList<CueCard> tempList = new ArrayList<>();

        //randomizing the cards

        while (Subject.practiceList.size() > 0) {
            int card = ThreadLocalRandom.current().nextInt(0, Subject.practiceList.size());

            tempList.add(Subject.practiceList.get(card));
            Subject.practiceList.remove(card);
        }

        Subject.practiceList.addAll(tempList);
    }





    @FXML
    private void handlePreviousCard(ActionEvent event) throws IOException {
        if (event.getSource() == prev_card_btn){
            GetPreviousCard();
        }
    }



    /***
     * gets the previous card in the list when studying
     * @return the previous question and answer or an empty ArrayList if there was an error
     */
    public ArrayList<String> GetPreviousCard() {

        ArrayList<String> card = new ArrayList<>();

        if (Subject.cueCardsList.size() == 0) {
            System.out.println("No cue cards have been made");
            return card;
        }

        //making sure that practice list is up to date
        if (Subject.updated) {
            Subject.practiceList.clear();
            Subject.practiceList.addAll(Subject.cueCardsList);

            Subject.updated = false;
        }

        //changing the current card
        if (Subject.currentCard == null) {
            Subject.currentCard = Subject.practiceList.get(0);
        } else {
            if (Subject.practiceList.indexOf(Subject.currentCard) == 0) {//wrap around to end
                Subject.currentCard = Subject.practiceList.get(Subject.practiceList.size() - 1);
            } else {
                Subject.currentCard = Subject.practiceList.get(Subject.practiceList.indexOf(Subject.currentCard) - 1);
            }
        }

        card.add(Subject.currentCard.GetQuestion());
        card.add(Subject.currentCard.GetAnswer());

        return card;
    }



    @FXML
    private void handleNextCard(ActionEvent event) throws IOException {
        if (event.getSource() == next_card_btn){
            GetNextCard();
        }
    }

    /***
     * gets the next card in the list when studying
     * @return the next question and answer or an empty ArrayList if there was an error
     */
    public ArrayList<String> GetNextCard() {
        ArrayList<String> card = new ArrayList<>();

        if (Subject.cueCardsList.size() == 0) {
            System.out.println("No cue cards have been made");
            return card;
        }

        //making sure that practice list is up to date
        if (Subject.updated) {
            Subject.practiceList.clear();
            Subject.practiceList.addAll(Subject.cueCardsList);

            Subject.updated = false;
        }

        //changing the current card
        if (Subject.currentCard == null) {
            Subject.currentCard = Subject.practiceList.get(0);
        } else {//increase the index by one
            Subject.currentCard = Subject.practiceList.get((Subject.practiceList.indexOf(Subject.currentCard) + 1) % Subject.practiceList.size());
        }

        card.add(Subject.currentCard.GetQuestion());
        card.add(Subject.currentCard.GetAnswer());

        return card;
    }





}
