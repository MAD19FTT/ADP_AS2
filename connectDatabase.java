package Practice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class connectDatabase {
	static int ticket = 0;
	static ArrayList <Integer> tempSeat = new ArrayList();

	public static Connection connect() throws Exception { //connect database driver
		Properties properties = new Properties();
		properties.load(
				new FileInputStream("application.properties"));

		String dbDriver = properties.getProperty("db.driver");
		String dbURL = properties.getProperty("db.url");
		String dbUsername = properties.getProperty("db.username");
		String dbPassword = properties.getProperty("db.password");

		// 1) LOADING DRIVER
		Class.forName(dbDriver);

		// 2) ESTABLISHING CONNECTION
		Connection dbConnect = 
				DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		return dbConnect;	
	}

	public static boolean login(String username, String password) throws Exception { //connect login table
		Connection dbConnect = connect();
		String sql = "SELECT username FROM customer WHERE"
				+ " username=? " + "AND password=?";
		//		Statement statement = dbConnect.createStatement();
		PreparedStatement statement = dbConnect.prepareStatement(sql); // to protect from login
		statement.setString(1, username); // to protect from login
		statement.setString(2, password); //to protect from login 
		// 4) EXECUTING STATEMENT
		ResultSet resultSet = statement.executeQuery();

		// 5) PROCESSING RESULT SET
		boolean validated = false;

		if(resultSet.next()) {
			validated = true;
		} else {
			validated = false;
		}

		dbConnect.close();
		return validated;
	}

	public static boolean register(String name, String username, String phoneNumber, String password, String email, String gender) throws Exception { //connect register table
		Connection dbConnect = connect();

		String sql = "INSERT INTO customer (username, password, name, email, gender, phoneNumber) VALUES " + "(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = 
				dbConnect.prepareStatement(sql);
		statement.setString(1,  username);
		statement.setString(2,  password);
		statement.setString(3,  name);
		statement.setString(4, email);
		statement.setString(5, gender);
		statement.setString(6, phoneNumber);

		boolean success = false;
		try {
			statement.executeUpdate();
			success = true;
		} catch (SQLException e) {
			success = false;
		}

		dbConnect.close();
		return success;
	}

	public static void timeSchedule(ArrayList<Button> times) throws Exception { //connect to time list movie table
		Connection dbConnect = connect();
		int ids = 1;
		int count = 0;
		String key = Integer.toString(ids);
		String sql = "SELECT startTime FROM schedule\r\n"
				+ "WHERE movie_id = ? ;";
		PreparedStatement statement = dbConnect.prepareStatement(sql);
		statement.setString(1,  key);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()){
			String time = resultSet.getString(1);
			times.get(count).setText(time);
			count ++;
		}
		dbConnect.close();
	}

	public static void Seat(ArrayList<Button> seat) throws Exception { //set booking or lock seat upon opening
		int i = 0;

		Connection dbConnect = connect();
		String sql = "SELECT available FROM seats;";
		Statement statement = dbConnect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while(resultSet.next()) {
			boolean status = (boolean) resultSet.getObject(1);
			if(status == true) {
				seat.get(i).setStyle("-fx-background-color: red; ");
			}
			i ++;
		}
		dbConnect.close();
	}

	public static void tempFill(ArrayList<Button> seat, ActionEvent e) throws Exception { //press fill to show which seat is select
		int i = 0;

		Connection dbConnect = connect();
		String sql = "SELECT available FROM seats;";
		Statement statement = dbConnect.createStatement();
		//		statement.addBatch(sql);
		ResultSet resultSet = statement.executeQuery(sql);

		while(resultSet.next()) {
			boolean status = (boolean) resultSet.getObject(1);
			if(e.getSource() == seat.get(i) && status == false) {
				seat.get(i).setStyle("-fx-background-color: #3c7fb1; "); //click to select
				ticket ++;
				tempSeat.add(i+1);
			}
			i ++;
		}
		dbConnect.close();
	}

	public static void resetTemp(ArrayList<Button> seat) throws Exception { //reset the selected seat
		int i = 0;

		Connection dbConnect = connect();
		String sql = "SELECT available FROM seats;";
		Statement statement = dbConnect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while(resultSet.next()) {
			boolean status = (boolean) resultSet.getObject(1);
			if(status == false) {
				seat.get(i).setStyle("-fx-background-color: white; "); 
				ticket = 0;
				tempSeat.clear();
			}
			i ++;
		}
		dbConnect.close();
	}

	public static void confirmSeat() throws Exception { //update the confirm booked seat to the database
		Connection dbConnect = connect();

		String sql = "UPDATE seats SET available=1" + " WHERE seat_id=?";
		PreparedStatement statement = 
				dbConnect.prepareStatement(sql);

		for(int i = 0; i < tempSeat.size(); i++ ) {
			String text = tempSeat.get(i).toString();
			//			statement.setString(1, id_movie);
			statement.setString(1,  text);
			statement.executeUpdate();
		}
		dbConnect.close();
	}

	//	public static void updateList(String currentTime) throws Exception {
	//		Connection dbConnect = connect();
	//
	//		String sql = "DELETE FROM schedule" + " WHERE startTime < ?";
	//		PreparedStatement statement = 
	//				dbConnect.prepareStatement(sql);
	//		statement.setString(1,  currentTime);
	//		statement.executeUpdate();
	//		dbConnect.close();
	//	}

	public static String setTicket() { //pass the value to payment page
		Integer mount = ticket; 
		String amount = mount.toString();
		return amount;
	}

	public static String setTotal() { //pass the value to payment page
		Integer totals = ticket * 7; 
		String totalPrice = totals.toString();
		return totalPrice;
	}


}
