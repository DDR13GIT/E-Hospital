package com.example.ehospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DepartmentNameFxid.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        DescriptionFxid.setCellValueFactory(new PropertyValueFactory<>("description"));
        StatusFxid.setCellValueFactory(new PropertyValueFactory<>("status"));
        DepartmentIdFxid.setCellValueFactory(new PropertyValueFactory<>("departmentId"));
        SerialNoFxid.setCellValueFactory(new PropertyValueFactory<>("serialNo"));


    }
}

