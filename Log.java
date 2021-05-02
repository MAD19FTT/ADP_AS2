package Practice;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;



public class Log {
	@FXML
	TextField username;
	@FXML
	TextField passcode;
	@FXML
	ImageView openEye, closeEye;
	@FXML
	Label error;
	@FXML
	HBox passHbox;

	
	public void Login() throws IOException {
		String user = username.getText();
		String password = passcode.getText();
		if(user.equals("mom") && password.equals("meme")) {
			Parent root = FXMLLoader.load(getClass().getResource("./Home.fxml"));
			 Scene scene = new Scene(root, 300, 500);
			
			 cinemaApp.mainStage.setScene(scene);
		}
		else {
			error.setText("Incorrect username or password !");
		}
	}
	
	public void showPassword(ActionEvent e) {
		CheckBox checkbox =(CheckBox) e.getSource();
		String password  = passcode.getText();
		passHbox.getChildren().remove(passcode);
		
		if(checkbox.isSelected()) {
			passcode =  new TextField(password);
			
		}
		else {
			
			passcode = new PasswordField();
			passcode.setText(password);
		}
		passHbox.getChildren().add(passcode);
	}
	
	
//	public void initialize() {
//		 Image img1 = new Image("/Practice/pic/panther.jpg");
//		 Image img2 = new Image("/Practice/pic/eye2.jpg");
//		 openEye.setImage(img1);
//	
//	}

}
