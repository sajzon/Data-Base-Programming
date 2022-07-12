package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentSaveFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtNic;

    public void SaveOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address= txtAddress.getText();
        String email= txtEmail.getText();
        String contact= txtContact.getText();
        String nic= txtNic.getText();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/IJSE2",
                    "root",
                    "1234"
            );
            Statement stm=con.createStatement();
            String query = "INSERT INTO Student VALUES("+"'"+id+"'"+","+"'"+name+"'"+","+"'"+address+"'"+","+"'"+email+"'"+","+"'"+contact+"'"+","+"'"+nic+"'"+")";
            final int i = stm.executeUpdate(query);
            if (i>0){
                System.out.println("Saved");
            }else {
                System.out.println("Try Again");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
