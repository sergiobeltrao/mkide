package mkide.com.mkide;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void closeHomeWindow() {
        if (stage != null) {
            stage.close();
        }
    }

    @FXML
    protected void openConnectionConfiguration() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connection.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage connectionStage = new Stage();
            connectionStage.setTitle("Connection configuration");
            connectionStage.setScene(scene);
            connectionStage.show();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }

    @FXML
    protected void aboutThisProgram() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("about.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage connectionStage = new Stage();
            connectionStage.setTitle("About the program");
            connectionStage.setScene(scene);
            connectionStage.show();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}