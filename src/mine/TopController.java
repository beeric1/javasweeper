package mine;

import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * @author Eric
 */
public class TopController {

    private SceneCreator creator;
    public int n = 10;

    public void setCreator(SceneCreator creator) {
        this.creator = creator;
    }

    @FXML
    private void exitGame(){
        Platform.exit();
    }

    @FXML
    private void newGame(){
        startGame();
    }


    private void startGame(){
        try {
            creator.first = true;
            creator.createScene(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void low(){
        n = 10;
        startGame();
    }

    @FXML
    private void medium(){
        n = 16;
        startGame();
    }

    @FXML
    private void high(){
        n = 25;
        startGame();
    }

    @FXML
    private void custom(){

    }


}
