package mine;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class TopController {

    //Game
    @FXML
    private MenuItem newgame;

    @FXML
    private MenuItem exitgame;

    //Difficulty
    @FXML
    private MenuItem low;

    @FXML
    private MenuItem medium;

    @FXML
    private MenuItem high;

    @FXML
    private MenuItem custom;

    @FXML
    private void exitGame(){
        Platform.exit();
    }

}
