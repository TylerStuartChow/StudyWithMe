package com.example.demo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/** Kayden */
public class SettingsController extends SaveState implements Initializable {

    // Variable used across multiply instances to check if darkMode is enabled or not
    public static BooleanProperty darkMode = new SimpleBooleanProperty();
    // Save variable for darkMode
    private boolean isDarkMode;
    // Variable to store user's name
    private String name;
    // Variable to store user's role
    private Role role;
    // Variable to store the path for load and save functions
    private transient String path = devFolder + "/Settings.json";


    // FXML variable to hold certain
    @FXML
    private transient ChoiceBox<Role> roles;

    @FXML
    private transient TextField nameBox;

    @FXML
    private transient Pane parent;

    // Role type to limit the possible roles
    private enum Role{
        Student_High,
        Student_Uni,
        Teacher,
        Trainee,
        Individual,
        Other,
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // temporary SettingsController to set the values from the load file
        SettingsController temp = SaveState.LoadObject(path, SettingsController.class);

        // Check if the temporary SettingController is null, if not then set values
        if (temp != null) {
            this.setDarkMode(temp.getDarkMode());
            this.setName(temp.getName());
            this.setRole(temp.getRole());
        }

        // Add the roles to the choiceBox
        roles.getItems().addAll(Role.Student_High, Role.Student_Uni, Role.Teacher, Role.Trainee, Role.Individual, Role.Other);

        // If role is null, set the choiceBox to default type (Other)
        if (this.role == null) {
            roles.setValue(Role.Other);
        }
        // Set the choiceBox to the user's role
        else {
            roles.setValue(this.role);
        }
        // Set the name in the textField to the user's name
        nameBox.setText(this.name);
        // Set the Color mode to the correct one
        this.changeMode(parent);

    }

    /**
     * Sets the name and role to the given inputs from textField and choiceBox,
     * and Then save all user settings into a save file
     */
    public void save() {
        // Setting role and name from choiceBox and textField
        setRole(roles.getSelectionModel().getSelectedItem());
        setName(nameBox.getText());

        // Setting the save darkMode variable
        this.isDarkMode = SettingsController.darkMode.getValue();

        // Temporary SettingsController used to save the user settings
        SettingsController temp = new SettingsController();
        temp.setName(this.getName());
        temp.setRole(this.getRole());
        temp.isDarkMode = this.getDarkMode();

        // Save the user settings to the save file
        SaveState.Save(path, temp);
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Role getRole(){
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private void setDarkMode(Boolean darkMode) {
        SettingsController.darkMode.setValue(darkMode);
    }

    public boolean getDarkMode(){ return this.isDarkMode;
    }


    /**
     * Sets the Settings page to dark mode and sets the value of darkMode to ture
     */
    private void setDarkMode(){
        parent.getStylesheets().remove(getClass().getResource("lightMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("darkMode.css").toExternalForm());
        SettingsController.darkMode.setValue(true);
    }


    /**
     * Sets the Settings page to light mode and sets the value of darkMode to false
     */
    private void setLightMode(){
        parent.getStylesheets().remove(getClass().getResource("darkMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("lightMode.css").toExternalForm());
        SettingsController.darkMode.setValue(false);
    }


    /**
     * Changes the color modes for settings page, if the page is in light mode then it switch it to dark mode, and vice versa
     */
    // For internal use only
    public void changeMode(){
        if (SettingsController.darkMode.getValue()) {
            setLightMode();
        }
        else {
            setDarkMode();
        }
    }


    /**
     * Changes the color modes for the given page,
     * It will change the page to mode that settings page is currently set to
     * @param parent The given page, that needs the mode change
     */
    // For external use
    public void changeMode(Parent parent){
        if (SettingsController.darkMode.getValue()) {
            setDarkMode(parent);
        }
        else {
            setLightMode(parent);
        }
    }


    /**
     * Sets the given page to dark mode.
     * @param parent The given page, that needs the mode change
     */
    public void setDarkMode(Parent parent){
        parent.getStylesheets().remove(getClass().getResource("lightMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("darkMode.css").toExternalForm());
    }


    /**
     * Sets the given page to light mode.
     * @param parent The given page, that needs the mode change
     */
    public void setLightMode(Parent parent){
        parent.getStylesheets().remove(getClass().getResource("darkMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("lightMode.css").toExternalForm());
    }
}