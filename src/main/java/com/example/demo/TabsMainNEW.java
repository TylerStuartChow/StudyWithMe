<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.ScrollBar?>
<?import javafx.scene.control.Tab?>
<?import javafx.scene.control.TabPane?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.Pane?>
<?import javafx.scene.layout.StackPane?>
<?import javafx.scene.text.Font?>

<TabPane prefHeight="450" prefWidth="600" tabClosingPolicy="UNAVAILABLE" xmlns="http://javafx.com/javafx/19" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.TabsController">
    <tabs>
       
        <Tab style="-fx-background-color: #AFEEEE;" text="PDFs">
            <content>
                <AnchorPane minHeight="0" minWidth="0" prefHeight="200" prefWidth="250" style="-fx-background-color: #FFFFFF;">
               <children>
                  <Button fx:id="btn_importFile" layoutX="177.0" layoutY="366.0" mnemonicParsing="false" onAction="#handleImport" style="-fx-background-color: #AFEEEE;" text="Import PDF">
                     <font>
                        <Font size="18.0" />
                     </font>
                  </Button>
                  <Pane prefHeight="75.0" prefWidth="600.0" style="-fx-background-color: #AFEEEE;" AnchorPane.bottomAnchor="346.40000000000003" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="1.0" AnchorPane.topAnchor="0.0">
                     <children>
                        <Label layoutX="272.0" layoutY="20.0" text="PDFs">
                           <font>
                              <Font name="System Bold" size="24.0" />
                           </font>
                        </Label>
                     </children>
                  </Pane>
                  <Button fx:id="btn_openFile1" layoutX="308.0" layoutY="366.0" mnemonicParsing="false" onAction="#handleOpen" style="-fx-background-color: #AFEEEE;" text="Open PDF">
                     <font>
                        <Font size="18.0" />
                     </font>
                  </Button>
                  <Pane layoutX="2.0" layoutY="75.0" prefHeight="272.0" prefWidth="600.0" style="-fx-background-color: #FFFFFF;">
                     <children>
                        <ScrollBar layoutX="578.0" layoutY="1.0" orientation="VERTICAL" prefHeight="271.0" prefWidth="20.0" />
                        <Button fx:id="btn_openFile2" layoutX="39.0" layoutY="41.0" maxHeight="100.0" maxWidth="100.0" mnemonicParsing="false" onAction="#handleOpen" prefHeight="75.0" prefWidth="75.0" style="-fx-background-color: #FFFFFF;" />
                        <ImageView fitHeight="70.0" fitWidth="75.0" layoutX="41.0" layoutY="28.0" pickOnBounds="true" preserveRatio="true">
                           <image>
                              <Image url="@../images/folder.png" />
                           </image>
                        </ImageView>
                        <TextField layoutX="44.0" layoutY="86.0" prefHeight="25.0" prefWidth="70.0" style="-fx-background-color: #FFFFFF;" text="myFiles" />
                     </children>
                  </Pane>
               </children></AnchorPane>
            </content>
        </Tab>

        <Tab style="-fx-background-color: #B0E0E6;" text="Notes">
            <content>
                <AnchorPane minHeight="0" minWidth="0" prefHeight="200" prefWidth="250">
               <children>
                  <Pane prefHeight="75.0" prefWidth="600.0" style="-fx-background-color: #B0E0E6;">
                     <children>
                        <Label layoutX="261.0" layoutY="20.0" text="NOTES">
                           <font>
                              <Font name="System Bold" size="24.0" />
                           </font>
                        </Label>
                     </children>
                  </Pane>
                  <Button layoutX="249.0" layoutY="366.0" mnemonicParsing="false" style="-fx-background-color: #B0E0E6;" text="Add Note">
                     <font>
                        <Font size="18.0" />
                     </font>
                  </Button>
                  <Label layoutX="534.0" layoutY="366.0" />
                  <ImageView fitHeight="70.0" fitWidth="50.0" layoutX="540.0" layoutY="360.0" pickOnBounds="true" preserveRatio="true">
                     <image>
                        <Image url="@../images/trash-can.png" />
                     </image>
                  </ImageView>
               </children></AnchorPane>
            </content>
        </Tab>

        <Tab style="-fx-background-color: #87CEEB;" text="Flashcards">
            <content>
                <AnchorPane minHeight="0" minWidth="0" prefHeight="200.0" prefWidth="250.0">
               <children>
                  <Pane prefHeight="75.0" prefWidth="600.0" style="-fx-background-color: #87CEEB;">
                     <children>
                        <Label layoutX="224.0" layoutY="20.0" text="FLASHCARDS">
                           <font>
                              <Font name="System Bold" size="24.0" />
                           </font>
                        </Label>
                     </children>
                  </Pane>
                  <Button fx:id="study_btn" layoutX="313.0" layoutY="375.0" mnemonicParsing="false" onAction="#handleButton" style="-fx-background-color: #87CEEB;" text="Study">
                     <font>
                        <Font size="18.0" />
                     </font>
                  </Button>
                  <Button fx:id="add_btn" layoutX="219.0" layoutY="375.0" mnemonicParsing="false" onAction="#handleButton" style="-fx-background-color: #87CEEB;" text="Add ">
                     <font>
                        <Font size="18.0" />
                     </font>
                  </Button>
                  <StackPane fx:id="myPane" layoutX="150.0" layoutY="98.0" prefHeight="225.0" prefWidth="300.0" />
               </children>
            </AnchorPane>
            </content>
        </Tab>
    </tabs>
</TabPane>
