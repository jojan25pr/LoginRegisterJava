
package registermvc;

import controller.LoginController;
import model.UserDAO;
import view.LoginForm;

public class RegisterMVC {
 
    public static void main(String[] args) {
        UserDAO model = new UserDAO();
        
        LoginForm loginForm = new LoginForm();
        LoginController loginController = new LoginController(loginForm, model);
        
        loginForm.setVisible(true);
    }
    
}


