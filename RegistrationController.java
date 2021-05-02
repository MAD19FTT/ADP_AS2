package Practice;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RegistrationController {
	
	@FXML
	TextField FirstNameTextField, LastNameTextField, PhoneNumberTextField, confirmPhoneNumberTextField, passwordPasswordField, 
			confirmpasswordPasswordField;
	
	@FXML
	RadioButton maleRadioButton, femaleRadioButton;
	
	@FXML
	HBox passwordHBox, confirmpasswordHBox;
	
	@FXML
	Button Register;
	
	@FXML
	ToggleGroup genderToggleGroup;
	
	public void register() throws Exception {
		
		String firstName = FirstNameTextField.getText();
		String lastName = LastNameTextField.getText();
		String phoneNumber = PhoneNumberTextField.getText();
		String confirmphoneNumber = confirmPhoneNumberTextField.getText();
		String password = passwordPasswordField.getText();
		String confirmpassword = confirmpasswordPasswordField.getText();
		
		RadioButton genderRadioButton = (RadioButton) genderToggleGroup.getSelectedToggle();
		boolean male = true;
		if(genderRadioButton.getText().equals("Male")){
				male = true;
		}else {
			male = false;
		}
	
	}
		
	public void showPassword(ActionEvent e) {
		CheckBox checkbox = (CheckBox) e.getSource();
		String password = passwordPasswordField.getText();
		String confirmpassword = confirmpasswordPasswordField.getText();
		passwordHBox.getChildren().remove(passwordPasswordField);
		confirmpasswordHBox.getChildren().remove(passwordPasswordField);
		
		
		if(checkbox.isSelected()) {
			passwordPasswordField = new TextField(password);
			confirmpasswordPasswordField = new TextField(confirmpassword);
			
		}
		else {
			
			passwordPasswordField = new PasswordField();
			passwordPasswordField.setText(password);
			
			confirmpasswordPasswordField = new PasswordField();
			confirmpasswordPasswordField.setText(confirmpassword);
			
		}
		passwordHBox.getChildren().add(passwordPasswordField);
		confirmpasswordHBox.getChildren().add(confirmpasswordPasswordField);
	}
}
