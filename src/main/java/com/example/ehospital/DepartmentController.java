package com.example.ehospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DepartmentController implements Initializable {
    ObservableList<DepartmentTableModel> departmentList = FXCollections.observableArrayList();
    @FXML
    public TextField Deptnamefxid;
    @FXML
    public TextField Des_fxid;
    @FXML
    public TextField Status_fxid;
    @FXML
    public TextField DeptIdid;

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
    DepartmentTableModel dept;

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

    public void InsertBtn(ActionEvent actionEvent)  throws SQLException {
        PreparedStatement pst = null;
        try {
            String query = " INSERT INTO Department ( DepartmentName, Description, Status) VALUES(?,?,?)";

            pst = conn.prepareStatement(query);
            String depname=Deptnamefxid.getText();
            String des= Des_fxid.getText();
            String sta= Status_fxid.getText();

            if(depname.equals("") || des.equals("")||sta.equals(""))
            {
                Notifications.create()
                        .title("Warning")
                        .text("Please fillup all the information")
                        .showError();

            }
            else
            {

                pst.setString(1, depname);
                pst.setString(2, des);
                pst.setString(3, sta);




                pst.executeUpdate();
                Notifications.create()
                        .title("Info")
                        .text("Added Successfully")
                        .show();
                System.out.println("inserted");



            }

        } catch (Exception e) {
            e.printStackTrace();
        
        }

        }


    public void UpdateBtn(ActionEvent actionEvent) {
    }

    public void DeleteBtn(ActionEvent actionEvent) {
        PreparedStatement pst = null;
        Connection con;
        try {

            dept=DepartmentTableFxid.getSelectionModel().getSelectedItem();
            String sql="DELETE FROM Department  WHERE Department.DepartmentName=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,dept.getDepartmentName());
            pst.executeUpdate();
            Notifications.create()
                    .title("Info")
                    .text("Deleted Successfully")
                    .show();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public void ResetBtn(ActionEvent actionEvent) throws SQLException {

        departmentList.clear();
        fetch_info();
    }
}


