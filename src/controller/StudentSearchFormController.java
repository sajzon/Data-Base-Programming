package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class StudentSearchFormController {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtNic;
    public TextField txtId;

    public void SearchOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/IJSE2",
                    "root",
                    "1234"
            );
            Statement stm=con.createStatement();
            String query = "SELECT * FROM Student WHERE studentId='"+id+"'";
            ResultSet set = stm.executeQuery(query);
            if (set.next()){
                String tempId = set.getString(1);
                String tempName = set.getString(2);
                String tempAddress = set.getString(3);
                String tempEmail = set.getString(4);
                String tempContact = set.getString(5);
                String tempNic = set.getString(6);

                txtId.setText(tempId);
                txtName.setText(tempName);
                txtAddress.setText(tempAddress);
                txtEmail.setText(tempEmail);
                txtContact.setText(tempContact);
                txtNic.setText(tempNic);
            }else {
                new Alert(Alert.AlertType.WARNING,"Empty Result Set").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
