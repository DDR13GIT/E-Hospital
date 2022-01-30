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

public class DepartmentController implements Initializable {
    ObservableList<DepartmentTableModel> departmentList = FXCollections.observableArrayList();

    @FXML
    private TableView<DepartmentTableModel> DepartmentTableFxid;
    @FXML
    private TableColumn<DepartmentTableModel, String> DepartmentNameFxid;

    @FXML
    private TableColumn<DepartmentTableModel, String> DescriptionFxid;

    @FXML
    private TableColumn<DepartmentTableModel, String> StatusFxid;

    @FXML
    private TableColumn<DepartmentTableModel, String> DepartmentIdFxid;

    @FXML
    private TableColumn<DepartmentTableModel, String> SerialNoFxid;

    Connection conn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DatabaseConnect.Connection();
        conn = DatabaseConnect.con;

        fetch_info();

    }

    public void fetch_info() {

        DepartmentNameFxid.setCellValueFactory(new PropertyValueFactory("DepartmentName"));
        DescriptionFxid.setCellValueFactory(new PropertyValueFactory("Description"));
        StatusFxid.setCellValueFactory(new PropertyValueFactory("Status"));
        DepartmentIdFxid.setCellValueFactory(new PropertyValueFactory("DepartmentId"));
        SerialNoFxid.setCellValueFactory(new PropertyValueFactory<>("SerialNo"));

        try {
            Statement st = conn.createStatement();
            String fetch_query = "select * from Department";
            ResultSet rs = st.executeQuery(fetch_query);

            while (rs.next()) {

                String departmentName = rs.getString("DepartmentName");
                String description = rs.getString("Description");
                String departmentID = rs.getString("DepartmentID");
                String status = rs.getString("Status");
                int serialNo = rs.getInt("SerialNo");
                departmentList.add(new DepartmentTableModel(departmentName, description, status, departmentID, serialNo));
            }
            DepartmentTableFxid.setItems(departmentList);
        } catch (Exception e) {

        }

    }

}

