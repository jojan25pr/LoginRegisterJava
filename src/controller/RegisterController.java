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
import model.User;
import model.UserDAO;
import view.LoginForm;
import view.RegisterForm;

public class RegisterController {
    private RegisterForm view;
    private UserDAO model;

    public RegisterController(RegisterForm view, UserDAO model) {
        this.view = view;
        this.model = model;

        this.view.getBtnRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        
        this.view.getLblLogin().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view.dispose();
                LoginForm loginForm = new LoginForm();
                LoginController loginController = new LoginController(loginForm, model);
                loginForm.setVisible(true);
            }
        });
    }
    
    

    private void registerUser() {
        String fullName = view.getFullName();
        String username = view.getUsername();
        String password = view.getPassword();
        String confirmPassword = view.getConfirmPassword();
        String phone = view.getPhone();

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(view, "Passwords do not match!");
            return;
        }
        
        String encryptedPassword = hashPassword(password);

        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        user.setPhone(phone);

        if (model.registerUser(user)) {
            JOptionPane.showMessageDialog(view, "User registered successfully!");
        } else {
            JOptionPane.showMessageDialog(view, "Failed to register user.");
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



