package mine;

import javafx.fxml.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Controller {

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

    //Status bar
    @FXML
    private Text mines;

    @FXML
    private Text time;

    //Play ground
    @FXML
    private GridPane field;



}
