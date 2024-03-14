/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university_case_study;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private Button login_btn;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private Text wronglogin;
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        if ("admin".equals(email.getText().toLowerCase()) && "123456789".equals(password.getText())) {
            // Load the server_pane.fxml scene for the root user
            root = FXMLLoader.load(getClass().getResource("student.fxml"));
            stage = (Stage) login_btn.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            wronglogin.setText("Wrong Email or Password");
        }
    }
    
}
