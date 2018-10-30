package mine;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class TopController {

    private SceneCreator creator;

    public void setCreator(SceneCreator creator) {
        this.creator = creator;
    }

    @FXML
    private void exitGame(){
        Platform.exit();
    }

    @FXML
    private void newGame(){
        low();
    }


    private void startGame(int n){
        try {
            creator.first = true;
            creator.createScene(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void low(){
        startGame(10);
    }

    @FXML
    private void medium(){
        startGame(20);
    }

    @FXML
    private void high(){
        startGame(30);
    }

    @FXML
    private void custom(){

    }


}
