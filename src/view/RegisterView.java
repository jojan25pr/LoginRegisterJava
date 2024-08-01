/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Angie
 */
import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    private JTextField txtFullName, txtUsername, txtPhone;
    private JPasswordField txtPassword, txtConfirmPassword;
    private JButton btnRegister;
    private JLabel lblLogin;

    public RegisterView() {
        setTitle("Register Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Full Name:"));
        txtFullName = new JTextField();
        panel.add(txtFullName);

        panel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panel.add(txtUsername);

        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        panel.add(new JLabel("Confirm Password:"));
        txtConfirmPassword = new JPasswordField();
        panel.add(txtConfirmPassword);

        panel.add(new JLabel("Phone:"));
        txtPhone = new JTextField();
        panel.add(txtPhone);

        btnRegister = new JButton("Register");
        panel.add(btnRegister);

        lblLogin = new JLabel("Already have an account? Login");
        lblLogin.setForeground(Color.BLUE.darker());
        lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(lblLogin);

        add(panel);
    }

    public String getFullName() {
        return txtFullName.getText();
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    public String getConfirmPassword() {
        return new String(txtConfirmPassword.getPassword());
    }

    public String getPhone() {
        return txtPhone.getText();
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JLabel getLblLogin() {
        return lblLogin;
    }
}


