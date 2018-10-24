package mine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        SceneCreator creator = new SceneCreator(primaryStage);


        primaryStage.setTitle("JavaSweeper");
        creator.createScene(10);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void startGame(int n){

    }


}
