/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import model.UserDAO;
import view.LoginForm;
import view.RegisterForm;

public class LoginController {
    private LoginForm view;
    private UserDAO model;

    public LoginController(LoginForm view, UserDAO model) {
        this.view = view;
        this.model = model;

        this.view.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

        this.view.getLblRegister().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.dispose();
                RegisterForm registerForm = new RegisterForm();
                RegisterController registerController = new RegisterController(registerForm, model);
                registerForm.setVisible(true);
            }
        });
    }

    private void loginUser() {
        String username = view.getUsername();
        String password = view.getPassword();

        // Encriptar la contraseña ingresada
        String hashedPassword = hashPassword(password);

        if (model.authenticateUser(username, hashedPassword)) {
            JOptionPane.showMessageDialog(view, "Access granted!");
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password.");
        }
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found", e);
        }
    }
    
}


