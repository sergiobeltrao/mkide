package com.mkide.controller;

import com.mkide.EditorModel;
import com.mkide.IOResult;
import com.mkide.RscFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MainController {

    private Stage stage;
    @FXML
    private TextArea txtCodeEditor;
    private RscFile currentRscFile;
    private EditorModel model;

    @FXML
    public void initializeEditorModel(EditorModel model) {
        this.model = model;
    }

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/mkide/views/connection.fxml"));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/mkide/views/about.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage connectionStage = new Stage();
            connectionStage.setTitle("About the program");
            connectionStage.setScene(scene);
            connectionStage.show();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }

    }

    @FXML
    private void onSave() {
        RscFile rscFile = new RscFile(currentRscFile.getFile(), Arrays.asList(txtCodeEditor.getText().split("\n")));
        model.save(rscFile);
    }

    @FXML
    private void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            IOResult<RscFile> io = model.load(file.toPath());

            if (io.isOk() && io.hasData()) {
                currentRscFile = io.getData();

                txtCodeEditor.clear();
                currentRscFile.getContent().forEach(line -> txtCodeEditor.appendText(line + "\n"));
            } else {
                System.out.println("Failed");
            }
        }
    }
}