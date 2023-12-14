module mkide.com.mkide {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens mkide.com.mkide to javafx.fxml;
    exports mkide.com.mkide;
}