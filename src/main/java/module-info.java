module mkide.com.mkide {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jsch;

    opens com.mkide to javafx.fxml;
    exports com.mkide;
}