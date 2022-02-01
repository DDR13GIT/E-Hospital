package com.example.ehospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class patientController {

    ObservableList<PatientTableModel> patientList = FXCollections.observableArrayList();

    @FXML
    private TableView<PatientTableModel> PatientTableFxid;

    @FXML
    private TableColumn<?, ?> PatientAddressFxid;

    @FXML
    private TextField PatientAddress_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientBloodGroupFxid;

    @FXML
    private TextField PatientBloodGroup_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientCreateDateFxid;

    @FXML
    private DatePicker PatientCreateDate_TfFxid;

    @FXML
    private Button PatientDeleteBtn_fxid;

    @FXML
    private TableColumn<?, ?> PatientDobFxid;

    @FXML
    private DatePicker PatientDob_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientEmailFxid;

    @FXML
    private TextField PatientEmail_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientFirstNameFxid;

    @FXML
    private TextField PatientFirstName_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientGenderFxid;

    @FXML
    private TextField PatientGender_TfFxid;

    @FXML
    private Button PatientInsertBtn_fxid;

    @FXML
    private TableColumn<?, ?> PatientLastNameFxid;

    @FXML
    private TextField PatientLastName_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientMobileFxid;

    @FXML
    private TextField PatientMobile_TfFxid;

    @FXML
    private TableColumn<?, ?> PatientPhoneFxid;

    @FXML
    private TextField PatientPhone_TfFxid;

    @FXML
    private Button PatientResetBtn_fxid;

    @FXML
    private TableColumn<?, ?> PatientSerialNoFxid;

    @FXML
    private TableColumn<?, ?> PatientStatusFxid;

    @FXML
    private ComboBox<?> PatientStatus_TfFxid;

    @FXML
    private Button PatientUpdateBtn_fxid;

    Connection conn;

    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnect.Connection();
        conn = DatabaseConnect.con;
        fetch_info();
    }

    private void fetch_info() {
        PatientSerialNoFxid.setCellValueFactory(new PropertyValueFactory("SerialNo"));
        PatientFirstNameFxid.setCellValueFactory(new PropertyValueFactory("FirstName"));
        PatientLastNameFxid.setCellValueFactory(new PropertyValueFactory("LastName"));
        PatientEmailFxid.setCellValueFactory(new PropertyValueFactory("EmailAddress"));
        PatientMobileFxid.setCellValueFactory(new PropertyValueFactory<>("MobileNo"));
        PatientPhoneFxid.setCellValueFactory(new PropertyValueFactory("PhoneNo"));
        PatientAddressFxid.setCellValueFactory(new PropertyValueFactory("Address"));
        PatientGenderFxid.setCellValueFactory(new PropertyValueFactory("Gender"));
        PatientBloodGroupFxid.setCellValueFactory(new PropertyValueFactory("BloodGroup"));
        PatientDobFxid.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        PatientCreateDateFxid.setCellValueFactory(new PropertyValueFactory("CreateDate"));
        PatientStatusFxid.setCellValueFactory(new PropertyValueFactory<>("Status"));

        try {
            Statement st = conn.createStatement();
            String fetch_query = "select * from Patient";
            ResultSet rs = st.executeQuery(fetch_query);

            while (rs.next()) {

                String PatientFirstName = rs.getString("FirstName");
                String PatientLastName = rs.getString("LastName");
                String PatientEmail = rs.getString("EmailAddress");
                String PatientMobile = rs.getString("MobileNo");
                String PatientPhone = rs.getString("PhoneNo");
                String PatientAddress = rs.getString("Address");
                String PatientGender = rs.getString("Gender");
                String PatientBloodGroup = rs.getString("BloodGroup");
                String PatientDob = rs.getString("Dob");
                String PatientCreateDate = rs.getString("CreateDate");
                String PatientStatus = rs.getString("Status");
                int PatientSerialNo = rs.getInt("SerialNo");
                patientList.add(new PatientTableModel(PatientFirstName,PatientLastName,PatientEmail,
                        PatientMobile,PatientPhone, PatientAddress,PatientGender,PatientBloodGroup,
                        PatientDob,PatientCreateDate,PatientStatus,PatientSerialNo));
            }
            PatientTableFxid.setItems(patientList);
        } catch (Exception e) {

        }
    }

}

