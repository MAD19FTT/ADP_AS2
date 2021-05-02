package Practice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class cinemaApp extends Application{
	
	public static Stage mainStage;
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Parent root = 
				FXMLLoader.load(getClass().getResource("./Log.fxml"));
		Scene scene = new Scene(root, 300, 500);
		
		mainStage = arg0;
		arg0.setScene(scene);
		arg0.setResizable(true);
		arg0.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
