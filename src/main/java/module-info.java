module mkide.com.mkide {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.mkide to javafx.fxml;
    exports com.mkide;
}