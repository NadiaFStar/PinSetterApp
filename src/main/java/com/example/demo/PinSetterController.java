package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

public class PinSetterController {

    @FXML
    private PasswordField pinField;

    @FXML
    private PasswordField confirmField;

    @FXML
    private Label messageLabel;

    @FXML
    protected void handleSetPin() {

        String pin = pinField.getText();
        String confirm = confirmField.getText();

        //Reset styles
        pinField.setStyle("");
        confirmField.setStyle("");

        //Check if PIN is exactly 4 digits
        if (!pin.matches("^\\d{4}$")) {
            messageLabel.setText("PIN must be exactly 4 digits.");
            pinField.setStyle("-fx-border-color: red;");
            return;
        }

        //Prevent all identical digits (e.g., 1111)
        if (pin.matches("(\\d)\\1{3}")) {
            messageLabel.setText("PIN cannot have all identical digits.");
            pinField.setStyle("-fx-border-color: red;");
            return;
        }

        //Prevent simple sequential PINs
        if (pin.equals("1234") || pin.equals("4321")) {
            messageLabel.setText("PIN cannot be sequential.");
            pinField.setStyle("-fx-border-color: red;");
            return;
        }

        //Check if PINs match
        if (!pin.equals(confirm)) {
            messageLabel.setText("PINs do not match!");
            confirmField.setStyle("-fx-border-color: red;");
            return;
        }

        // Success
        messageLabel.setText("PIN set successfully!");
        pinField.setStyle("-fx-border-color: green;");
        confirmField.setStyle("-fx-border-color: green;");
    }
}