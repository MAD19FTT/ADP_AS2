package Practice;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class Home {
	@FXML
	ScrollPane scroll;
	@FXML
	ImageView image1, image2, image3, image4, image5, image6, image7, image8;
	 
	public void initialize() throws Exception {
		Image img = new Image("/Practice/pic/panther.jpg");
		Image img2 = new Image("/Practice/pic/aladdin.jpg");
		Image img3 = new Image("/Practice/pic/Avenge.jpg");
		Image img4 = new Image("/Practice/pic/1917.jpg");
		Image img5 = new Image("/Practice/pic/tom.jpg");
		Image img6 = new Image("/Practice/pic/us.jpg");
		Image img7 = new Image("/Practice/pic/godvkong.jpg");
		Image img8 = new Image("/Practice/pic/dunk.jpg");
		//File file = new File(getClass().getResource("/Practice/Scary.jpg").toURI());
		//FileInputStream fileStream = new FileInputStream(file);
        //Image image = new Image(fileStream);
        image1.setImage(img);
        image2.setImage(img2);
        image3.setImage(img3);
        image4.setImage(img4);
        image5.setImage(img5);
        image6.setImage(img6);
        image7.setImage(img7);
        image8.setImage(img8);
       // scroll.setPannable(true);
        }

	public void redirect() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("./Schedule.fxml"));
		 Scene scene = new Scene(root, 300, 500);
		 cinemaApp.mainStage.setScene(scene);
	}
	
}
