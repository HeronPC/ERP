package sge.proyectoerp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ERPApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Macaquisho");
        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("erp.fxml")));
        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}