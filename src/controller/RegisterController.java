/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);

        if (model.registerUser(user)) {
            JOptionPane.showMessageDialog(view, "User registered successfully!");
        } else {
            JOptionPane.showMessageDialog(view, "Failed to register user.");
        }
    }
}



