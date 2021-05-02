package Practice;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Schedule {
	@FXML
	ImageView image1;
	@FXML
	Button slot1, slot2, slot3, slot4, slot5, slot6;
	
	 ArrayList<String> time = new ArrayList<String>();
	  
	 public void redirect() throws IOException {
		 Parent root = FXMLLoader.load(getClass().getResource("./seatBook.fxml"));
		 Scene scene = new Scene(root, 300, 500);
		 cinemaApp.mainStage.setScene(scene);
	}
	
	public void initialize() {
		Image img = new Image("/Practice/pic/panther.jpg");
		image1.setImage(img);
		 time.add("11:00");
		 time.add("12:00");
		 time.add("13:00");
		 time.add("14:00");
		 time.add("15:00");
		 time.add("16:00"); 
		 slot1.setText(time.get(0));
		 slot2.setText(time.get(1));
		 slot3.setText(time.get(2));
		 slot4.setText(time.get(3));
		 slot5.setText(time.get(4));
		 slot6.setText(time.get(5));
	}
	
	
}

