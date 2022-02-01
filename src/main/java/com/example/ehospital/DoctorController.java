package com.example.ehospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {

    ObservableList<DoctorTableModel> doctorList = FXCollections.observableArrayList();

    @FXML
    private TableView<DoctorTableModel> DoctorTableFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> FnameFxid;

    @FXML
    private TableColumn<DoctorTableModel, String> LnameFxid;

    @FXML
    private TableColumn<DoctorTableModel, String> DepartmentFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> EmailAddressFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> MobileFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> PhoneFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> AddressFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> GenderFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> BGFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> DOBFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> UserRoleFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> JoinDateFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> StatusFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> FeesFxid;
    @FXML
    private TableColumn<DoctorTableModel, String> SerialNoFxid;



    Connection conn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnect.Connection();
        conn = DatabaseConnect.con;
        fetch_info();
    }

    public void fetch_info() {


        SerialNoFxid.setCellValueFactory(new PropertyValueFactory<>("SerialNo"));
        FnameFxid.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        LnameFxid.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        DepartmentFxid.setCellValueFactory(new PropertyValueFactory<>("Department"));
       EmailAddressFxid.setCellValueFactory(new PropertyValueFactory<>("EmailAddress" ));
        MobileFxid.setCellValueFactory(new PropertyValueFactory<>("MobileNo"));
        PhoneFxid.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        AddressFxid.setCellValueFactory(new PropertyValueFactory<>("Address"));
       GenderFxid.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        BGFxid.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
        DOBFxid.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        UserRoleFxid.setCellValueFactory(new PropertyValueFactory<>("UserRole"));
        JoinDateFxid.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        StatusFxid.setCellValueFactory(new PropertyValueFactory<>("Status"));
        FeesFxid.setCellValueFactory(new PropertyValueFactory<>("Fees"));

        try {
            Statement st = conn.createStatement();
            String fetch_query = "select * from DoctorTablecsv";
            ResultSet rs = st.executeQuery(fetch_query);

            while (rs.next()) {

                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String department = rs.getString("Department");
                String emailAddress = rs.getString("EmailAddress");
                String mobile = rs.getString("MobileNo");
                String phone = rs.getString("PhoneNo");
                String address = rs.getString("Address");
                String gender = rs.getString("Sex");
                String bloodgroup = rs.getString("BloodGroup");
                String dob = rs.getString("DOB");
                String userrole = rs.getString("UserRole");
                String joindate = rs.getString("JoinDate");
                String status = rs.getString("Status");
                int fees = rs.getInt("Fees");

                int serialNo = rs.getInt("SerialNo");
                doctorList.add(new DoctorTableModel(firstName, lastName,department,emailAddress,mobile,phone,address,gender,bloodgroup,dob,
                        userrole,joindate,status, fees, serialNo));
            }
            DoctorTableFxid.setItems(doctorList);
        } catch (Exception e) {

        }
    }

    }
