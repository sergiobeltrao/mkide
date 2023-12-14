package mkide.com.mkide;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 648);

        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.setTitle("mkide");
        stage.setScene(scene);
        stage.show();
    }
}