package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class StudentUpdateFormController {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtNic;
    public TextField txtId;

    public void UpdateOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        String tempId =txtId.getText();
        String tempName = txtName.getText();
        String tempAddress = txtAddress.getText();
        String tempEmail = txtEmail.getText();
        String tempContact =txtContact.getText();
        String tempNic =txtNic.getText();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/IJSE2",
                "root",
                "1234"
        );
        Statement stm=con.createStatement();
        String query ="UPDATE Student SET studentName='"+tempName+"',address='"+tempAddress+"',email='"+tempEmail+"',contact='"+tempContact+"',nic='"+tempNic+"'WHERE studentId='"+tempId+"'";
        if (stm.executeUpdate(query)>0) new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
        else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }
    }

    public void SelectStudentOnAction(ActionEvent actionEvent) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/IJSE2",
                    "root",
                    "1234"
            );
            Statement stm=con.createStatement();
            String query = "SELECT * FROM Student WHERE studentId='"+txtId.getText()+"'";
            ResultSet rst = stm.executeQuery(query);
            if (rst.next()){


                txtName.setText(rst.getString(2));
                txtAddress.setText(rst.getString(3));
                txtEmail.setText(rst.getString(4));
                txtContact.setText(rst.getString(5));
                txtNic.setText(rst.getString(6));
            }else {
                new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
