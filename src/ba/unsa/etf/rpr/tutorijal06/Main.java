package ba.unsa.etf.rpr.tutorijal06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/digitron.fxml"));
        primaryStage.setTitle("Digitron");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 350, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}