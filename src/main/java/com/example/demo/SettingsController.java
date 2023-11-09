package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/** Kayden */
public class SettingsController extends SaveState implements Initializable {


    private boolean darkMode;
    private String name;
    private Role role;
    private transient String path = devFolder + "/Settings.json";

    @FXML
    private transient ChoiceBox<Role> roles;

    @FXML
    private transient TextField nameBox;

    @FXML
    private transient Pane parent;

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

        SettingsController temp = SaveState.LoadObject(path, SettingsController.class);


            this.setDarkMode(temp.getDarkMode());
            this.setName(temp.getName());
            this.setRole(temp.getRole());

            System.out.println(this.name);



        roles.getItems().addAll(Role.Student_High, Role.Student_Uni, Role.Teacher, Role.Trainee, Role.Individual, Role.Other);
        if (this.role == null) {
            roles.setValue(Role.Other);
        }
        else {
            roles.setValue(this.role);
        }
        nameBox.setText(this.name);

    }

    public void save() {
        setRole(roles.getSelectionModel().getSelectedItem());
        setName(nameBox.getText());

        ArrayList saveList = new ArrayList<>();
        saveList.add(name);
        saveList.add(role);
        saveList.add(darkMode);


        SettingsController temp = new SettingsController();
        temp.setName(this.getName());
        temp.setRole(this.getRole());
        temp.setDarkMode(this.getDarkMode());

        System.out.println(this.getDarkMode());

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


    public void exit() {
        System.out.println(getRole());
        System.out.println(getName());
    }

    private void setDarkMode(){
        parent.getStylesheets().remove(getClass().getResource("lightMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("darkMode.css").toExternalForm());
        this.darkMode = true;
    }

    private void setLightMode(){
        parent.getStylesheets().remove(getClass().getResource("darkMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("lightMode.css").toExternalForm());
        this.darkMode = false;
    }

    // For internal use only
    public void changeMode(){
        if (this.darkMode) {
            setLightMode();
        }
        else {
            setDarkMode();
        }
    }


    // For external use
    public void changeMode(Parent parent){
        if (this.darkMode) {
            setDarkMode(parent);
        }
        else {
            setLightMode(parent);
        }
    }

    public void setDarkMode(Parent parent){
        parent.getStylesheets().remove(getClass().getResource("lightMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("darkMode.css").toExternalForm());
        System.out.println("Called dark");
    }

    public void setLightMode(Parent parent){
        parent.getStylesheets().remove(getClass().getResource("darkMode.css").toExternalForm());
        parent.getStylesheets().add(getClass().getResource("lightMode.css").toExternalForm());
        System.out.println("Called light");
    }


    private void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    private boolean getDarkMode(){
        return this.darkMode;
    }

}

