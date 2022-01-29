package com.example.ehospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.*;
import java.util.EventObject;

public class MainController {

    @FXML
    public TextField IdField;
    @FXML
  public PasswordField  PasswordField;
    @FXML
    public AnchorPane loginpane;
    public Button SigninBtn;
    PreparedStatement pst = null;
    ResultSet rs;



    public void SignInAction(ActionEvent actionEvent) {
        System.out.println("Sign in button clicked");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;user=team;password=p@ssword13;databaseName=EHdb";
            Connection con = DriverManager.getConnection(url);
            String uname = IdField.getText();
            String pass =  PasswordField.getText();


            if (uname.equals("") || pass.equals("")) {
                System.out.println("Please Fill up all the information");


            } else {
                String query = "SELECT * FROM  LoginInfo WHERE UserName=? and Password=?";


                pst = con.prepareStatement(query);
                pst.setString(1, uname);
                pst.setString(2, pass);
                rs = pst.executeQuery();
                if (rs.next()) {
//                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
//                    Stage stage = (Stage)(Window)SigninBtn.getScene().getWindow();
//                    Scene scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
                    AnchorPane dashboardPane = FXMLLoader.load(getClass().getResource("DASHBOARD.fxml"));
                    loginpane.getChildren().setAll(dashboardPane);

                } else {
                    System.out.println("Please Enter Correct email Or Password");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
