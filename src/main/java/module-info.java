module com.example.ehospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ehospital to javafx.fxml;
    exports com.example.ehospital;
}