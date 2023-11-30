package lk.ijse.chicagosystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.chicagosystem.util.Navigation;
import lk.ijse.chicagosystem.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFormController {

    public JFXTextField txtusername;
    public JFXPasswordField txtpassword;
    public JFXButton btnLog;
    public AnchorPane mainPane;
    public Label lblinvalidUserName;
    public Label lblInvalidPassword;


    public void unonAction(ActionEvent actionEvent) {
        txtpassword.requestFocus();
    }

    public void txtloginOnAction(ActionEvent actionEvent) {
        btnLog.fire();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

//   Navigation.navigate(Routes.ADMIN, mainPane);
//     Navigation.navigate(Routes.CASHIER, mainPane);
        //    Navigation.navigate(Routes.STOREKEEPER, mainPane);

        if (txtusername.getText().equals("Admin") && txtpassword.getText().equals("admin@22")) {
            Navigation.navigate(Routes.ADMIN, mainPane);
        } else if (txtusername.getText().equals("Cashier") && txtpassword.getText().equals("c@22")) {
            Navigation.navigate(Routes.CASHIER, mainPane);
        } else if (txtusername.getText().equals("Skeeper") && txtpassword.getText().equals("s@22")) {
            Navigation.navigate(Routes.STOREKEEPER, mainPane);
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid UserName or Password!").show();
        }


    }

    public void exitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    //User Name Checker
    public void userNameOnTyped(KeyEvent keyEvent) {
        Pattern usernamepattern = Pattern.compile("(^[a-zA-Z0-9]{4,}$)");
        Matcher usernamematcher = usernamepattern.matcher(txtusername.getText());
        boolean isMachedUser = usernamematcher.matches();
        if (!isMachedUser) {
            txtusername.requestFocus();
            txtusername.setFocusColor(Paint.valueOf("Red"));
            lblinvalidUserName.setText("*Invalid User Name");

        } else {
            txtusername.setFocusColor(Paint.valueOf("white"));
            lblinvalidUserName.setText("");
        }
    }

    //Password Checker
    // Default pw pattern   (^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$)
    public void passwordOnType(KeyEvent keyEvent) {
        Pattern passwordpattern = Pattern.compile("(^(?=.*\\d)(?=.*[a-zA-Z]).{3,}$)");
        Matcher passwordmatcher = passwordpattern.matcher(txtpassword.getText());
        boolean isMachedUser = passwordmatcher.matches();
        if (!isMachedUser) {
            txtpassword.requestFocus();
            txtpassword.setFocusColor(Paint.valueOf("Red"));
            lblInvalidPassword.setText("*Wrong Password");

        } else {
            txtpassword.setFocusColor(Paint.valueOf("white"));
            lblInvalidPassword.setText("");
        }

    }
}





