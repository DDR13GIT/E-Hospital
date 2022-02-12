package com.example.ehospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {
    @FXML
    private BorderPane mainPane;
    public Button departmentBtnFxid;

    public void departmentBtn(ActionEvent actionEvent) throws IOException {
       Fxmlloader object = new Fxmlloader();
//        Pane view = object.getPage("department");
//        mainPane.setCenter(view);

//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deparment.fxml")));
//        Stage stage = (Stage)(Window)departmentBtnFxid.getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        Parent root4 = FXMLLoader.load(getClass().getResource("department.fxml"));
        Scene scene4 = new Scene(root4);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.show();

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
