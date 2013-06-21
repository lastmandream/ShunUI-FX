package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import name.antonsmirnov.javafx.dialog.Dialog;
import sample.Main;
import sample.WindowButtons;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ToolBar tb;
    @FXML
    private Region spacer;
    @FXML
    private ImageView logo;
    @FXML
    private Region spacer2;

    private ResourceBundle resources = null;
    private double mouseDragOffsetX = 0;
    private double mouseDragOffsetY = 0;

    private Stage primaryStage;

    private WindowButtons windowButtons;

    @Override
    @SuppressWarnings("rawtypes")
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        this.primaryStage = Main.stage;

        //init the component
        HBox.setMargin(logo, new Insets(0, 0, 0, 5));
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        // add close min max
        windowButtons = new WindowButtons(primaryStage);
        tb.getItems().add(windowButtons);
        // add window header double clicking
        tb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    windowButtons.toogleMaximized();
                }
            }
        });
        // add window dragging
        tb.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                mouseDragOffsetX = event.getSceneX();
                mouseDragOffsetY = event.getSceneY();
            }
        });
        tb.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if(!windowButtons.isMaximized()) {
                    primaryStage.setX(event.getScreenX()-mouseDragOffsetX);
                    primaryStage.setY(event.getScreenY()-mouseDragOffsetY);
                }
            }
        });
    }



//    public void setStage(Stage stage) {
//        this.primaryStage = stage;
//    }

    public void click_handler(ActionEvent actionEvent) {
        //To change body of created methods use File | Settings | File Templates.

        EventHandler yesButtonHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                //To change body of implemented methods use File | Settings | File Templates.

            }
        };


        EventHandler noButtonHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        EventHandler cancelButtonHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        Dialog.buildConfirmation("test", "hello")
                .addYesButton(yesButtonHandler)
                .addNoButton(noButtonHandler)
                .addCancelButton(cancelButtonHandler)
                .build()
                .show();
    }



}
