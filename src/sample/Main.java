package sample;

import controllers.Controller;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Stage stage;
    private Scene scene;
    private WindowResizeButton windowResizeButton;
    private static Main shunUI;


    public static Main getShunUI() {
        return shunUI;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        shunUI = this;
        stage =  primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        CusBorderPane root = (CusBorderPane)fxmlLoader.load();
        root.getStyleClass().add("application");
        // create window resize button
        windowResizeButton = new WindowResizeButton(primaryStage, 1020,700);
        root.setWindowResizeButton(windowResizeButton);
        windowResizeButton.setManaged(false);
        root.getChildren().add(windowResizeButton);
        //Controller controller = fxmlLoader.<Controller>getController();
        //controller.setStage(primaryStage);


        primaryStage.setTitle("ShunUI");
         boolean is3dSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
        scene = new Scene(root, 1020, 700, is3dSupported);
        if (is3dSupported) {
            //RT-13234
            scene.setCamera(new PerspectiveCamera());
        }
        scene.getStylesheets().add(Main.class.getResource("/sample/temp.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
