package sge.proyectoerp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sge.proyectoerp.Controllers.ERPController;

import java.io.IOException;

public class ERPApplication extends Application {
    Scene scene;
    public Parent root;
    public Stage primaryStage;
    @Override
    public void start(Stage primaryStage){
        try {
            primaryStage.setTitle("Macaquisho");
            scene = initStage(500,700);
            //stage.setMaximized(true);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Scene initStage(int x, int y) throws IOException {
        root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        return new Scene(root, x, y);
    }

    public static void main(String[] args) {
        launch();
    }
}