package com.mkide;

import com.mkide.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/mkide/views/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 648);

        MainController controller = fxmlLoader.getController();
        // Passa o EditorModel para o MainController
        EditorModel editorModel = new EditorModel();
        controller.initializeEditorModel(editorModel);
        controller.setStage(stage);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/mkide/imagens/icon.png")));

        stage.setTitle("mkide");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
}