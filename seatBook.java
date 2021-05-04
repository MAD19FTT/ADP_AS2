package Practice;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import test.MyButton;


public class seatBook {
	Integer ticketCount = 0;
	@FXML
	Button seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9, 
	seat10, seat11, seat12, seat13, seat14, seat15, seat16, seat17, seat18,
	seat19, seat20, seat21, seat22, seat23, seat24, seat25, seat26, seat27,
	seat28, seat29, seat30, seat31, seat32;
	 int whichIsLastClicked = -1;

	ArrayList <Button> seats = new ArrayList();
	ArrayList <Boolean> bookList = new ArrayList();
	 
	public void bookFill(ActionEvent find) {
//		seatFill();
		for(int i = 0; i < 32; i++) {
		if(find.getSource() == seats.get(i) && bookList.get(i) == false) {
		seats.get(i).setStyle("-fx-background-color: #3c7fb1; "); //click again to unselect
		bookList.set(i, true);
			ticketCount ++;
		}
//		else {
//			seat2.setStyle("-fx-background-color: Yellow; "); //click seat to select seat
//			buttonOn ++;
//		}
	}//
	}
	
	public void cancelPage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("./Schedule.fxml"));
		 Scene scene = new Scene(root, 300, 500);
		 cinemaApp.mainStage.setScene(scene);
	}
	
	public void resetSeat() {
		for(int i = 0; i < 32; i++) {
			if(bookList.get(i) == false) {
			seats.get(i).setStyle("-fx-background-color: white; "); //click again to unselect
			bookList.set(i, false);
				ticketCount = 0;
				}
			}
	}
	
	public void setSeat(ActionEvent e) throws IOException {
		System.out.println(bookList);
		Parent root = FXMLLoader.load(getClass().getResource("./Payment.fxml"));
		 Scene scene = new Scene(root, 300, 500);
		 cinemaApp.mainStage.setScene(scene);
	}
	
	public void initialize() {
		seats.add(seat1);		bookList.add(true);
		seats.add(seat2);		bookList.add(false);
		seats.add(seat3);		bookList.add(false);
		seats.add(seat4);		bookList.add(false);
		seats.add(seat5);		bookList.add(false);
		seats.add(seat6);		bookList.add(false);
		seats.add(seat7);		bookList.add(false);
		seats.add(seat8);		bookList.add(false);
		seats.add(seat9);		bookList.add(false);
		seats.add(seat10);		bookList.add(false);
		seats.add(seat11);		bookList.add(false);
		seats.add(seat12);		bookList.add(false);
		seats.add(seat13);		bookList.add(false);
		seats.add(seat14);		bookList.add(false);
		seats.add(seat15);		bookList.add(false);
		seats.add(seat16);		bookList.add(false);
		seats.add(seat17);		bookList.add(false);
		seats.add(seat18);		bookList.add(false);
		seats.add(seat19);		bookList.add(false);
		seats.add(seat20);		bookList.add(false);
		seats.add(seat21);		bookList.add(false);
		seats.add(seat22);		bookList.add(false);
		seats.add(seat23);		bookList.add(false);
		seats.add(seat24);		bookList.add(false);
		seats.add(seat25);		bookList.add(false);
		seats.add(seat26);		bookList.add(false);
		seats.add(seat27);		bookList.add(false);
		seats.add(seat28);		bookList.add(false);
		seats.add(seat29);		bookList.add(false);
		seats.add(seat30);		bookList.add(false);
		seats.add(seat31);		bookList.add(false);
		seats.add(seat32);		bookList.add(false);
		
		for(int i = 0; i < 32; i++) {
			if(bookList.get(i) == true ) {
				//seats.get(i).setDisable(true);
			seats.get(i).setStyle("-fx-background-color: red; ");
			}
			
		}
	}
	
}
