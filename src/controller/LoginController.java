/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        if (model.authenticateUser(username, password)) {
            JOptionPane.showMessageDialog(view, "Access granted!");
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password.");
        }
    }
}


