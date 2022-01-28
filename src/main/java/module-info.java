module com.example.ehospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires  mssql.jdbc;


    opens com.example.ehospital to javafx.fxml;
    exports com.example.ehospital;
}