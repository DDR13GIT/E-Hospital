package com.example.ehospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class AdminDashboardController {
    @FXML
    private BorderPane mainPane;

    public void departmentBtn(ActionEvent actionEvent) {
        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("department");
        mainPane.setCenter(view);
    }

    public void doctorBtn(ActionEvent actionEvent) {
        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("DoctorList");
        mainPane.setCenter(view);
    }

    public void patientBtn(ActionEvent actionEvent) {
        Fxmlloader object = new Fxmlloader();
        Pane view = object.getPage("PatientList");
        mainPane.setCenter(view);
    }
}
