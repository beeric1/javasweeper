package mine;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Eric
 */
public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        SceneCreator creator = new SceneCreator(primaryStage);


        primaryStage.setTitle("JavaSweeper");
        primaryStage.setResizable(false);
        creator.createScene(10);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void startGame(int n){

    }


}
