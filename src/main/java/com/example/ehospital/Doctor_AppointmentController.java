package com.example.ehospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Doctor_AppointmentController implements Initializable {

    ObservableList<Doctor_AppoinmentTableModel> appointmentList = FXCollections.observableArrayList();


    @FXML
    private TableView<Doctor_AppoinmentTableModel> AppointmentTableFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentDateFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentDepartmentFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentDoctorIdFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentDoctortNameFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentPatientIdFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentProblemDesFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentTimeFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmentserialNoFxid;

    @FXML
    private TableColumn<Doctor_AppoinmentTableModel, String> AppointmnetIdFxid;

    @FXML
    private TextField keywordTextField;


    Connection conn;
    PreparedStatement pst;
    ResultSet rs;


    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnect.Connection();
        conn = DatabaseConnect.con;
        fetch_info();
        search();

    }

    private void fetch_info() {
        AppointmentserialNoFxid.setCellValueFactory(new PropertyValueFactory<>("SerialNo"));
        AppointmentDateFxid.setCellValueFactory(new PropertyValueFactory<>("AppointmentDate"));
        AppointmentTimeFxid.setCellValueFactory(new PropertyValueFactory<>("AppointmentTime"));
        AppointmentProblemDesFxid.setCellValueFactory(new PropertyValueFactory<>("ProblemDescription"));
        AppointmentPatientIdFxid.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        AppointmentDepartmentFxid.setCellValueFactory(new PropertyValueFactory<>("Department"));
        AppointmentDoctorIdFxid.setCellValueFactory(new PropertyValueFactory<>("DoctorId"));
        AppointmentDoctortNameFxid.setCellValueFactory(new PropertyValueFactory<>("DoctorName"));
        AppointmnetIdFxid.setCellValueFactory(new PropertyValueFactory<>("AppointmentId"));

        try {
            Statement st = conn.createStatement();
            String fetch_query = "select * from Appointment";
            ResultSet rs = st.executeQuery(fetch_query);

            while (rs.next()) {

                String appointmentDate = rs.getString("AppointmentDate");
                String appointmentTime = rs.getString("AppointmentTime");
                String probDes = rs.getString("ProblemDescription");
                String patientId = rs.getString("PatientId");
                String dept = rs.getString("Department");
                String appoinmentDate = rs.getString("DoctorId");
                String doctId = rs.getString("DoctorName");
                String appointmentId = rs.getString("AppointmentId");

                appointmentList.add(new Doctor_AppoinmentTableModel(appointmentDate, appointmentTime, probDes, patientId, dept, appoinmentDate, doctId, appointmentId));
            }
            AppointmentTableFxid.setItems(appointmentList);
        } catch (Exception e) {

        }
    }


    @FXML
    void AppointmentBackBTN(ActionEvent event) throws SQLException, IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("DoctorDashboard.fxml"));
        Scene scene1 = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    public void search()

    {
        FilteredList<Doctor_AppoinmentTableModel> filteredData = new FilteredList(appointmentList, b -> true);

        keywordTextField.textProperty().addListener((observable,oldvalue,newvalue)->{

            filteredData.setPredicate(Doctor_DoctorTableModel -> {

                if(newvalue.isEmpty() || newvalue==null)
                {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();

                if(Doctor_AppoinmentTableModel.get().toLowerCase().indexOf(searchKeyword) >-1)
                {
                    return true;
                }
                else if(Doctor_AppoinmentTableModel.get().toLowerCase().indexOf(searchKeyword) >-1)
                {
                    return true;
                }
                else if(Doctor_AppoinmentTableModel.get().toLowerCase().indexOf(searchKeyword) >-1)
                {
                    return true;
                }
                return false;




            });

        });

        SortedList<Doctor_AppoinmentTableModel> sortData = new SortedList<>(filteredData);
        sortData.comparatorProperty().bind(AppointmentTableFxid.comparatorProperty());

        AppointmentTableFxid.setItems(sortData);

    }



}


