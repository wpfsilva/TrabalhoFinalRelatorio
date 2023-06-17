package Interface;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
public class mainApplication extends Application{

	  @Override
	    public void start(Stage stage) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("main-view.fxml"));
	        Scene scene = new Scene(fxmlLoader.load(), 500, 650);
	        stage.setTitle("Hello!");
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
		 

	}

}
