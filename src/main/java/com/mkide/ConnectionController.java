package com.mkide;

import com.jcraft.jsch.JSchException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnectionController {
    @FXML
    private TextField txbUsername;
    @FXML
    private PasswordField txbPassword;
    @FXML
    private TextField txbDeviceIpAddress;
    @FXML
    private TextField txbPort;
    @FXML
    private TextField txbRemotePath;

    public void bntConnectActionPerformed() throws JSchException {

        if (errorCheck() != null) {
            System.out.println(errorCheck());
        } else {
            Sftp sftp = new Sftp();

            sftp.setUsername(txbUsername.getText());
            sftp.setPassword(txbPassword.getText());
            sftp.setHost(txbDeviceIpAddress.getText());
            sftp.setPort(Integer.parseInt(txbPort.getText()));
            sftp.setRemotePath(txbRemotePath.getText());

            sftp.Connection();
        }
    }

    public String errorCheck() {
        String errorMessage = null;

        if (txbUsername.getText().isBlank()) {
            errorMessage = "Please enter your username to proceed.";
        }

        if (txbPassword.getText().isBlank()) {
            errorMessage = "Please input your password to continue.";
        }

        if (txbDeviceIpAddress.getText().isEmpty()) {
            errorMessage = "Please provide the Router's IP address for connection.";
        }

        if (txbPort.getText().isEmpty()) {
            errorMessage = "The Router's port number is required for connection.";
        }

        if (txbRemotePath.getText().isEmpty()) {
            errorMessage = "To proceed, please specify the remote path for access.";
        }

        return errorMessage;
    }
}
