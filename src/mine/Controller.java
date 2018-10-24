package mine;

import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
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

    @FXML
    private BorderPane border;


    public GridPane addButtons(int n){

        GridPane field = new GridPane();

        for (int i = 0; i <n ; i++) {

            for (int j = 0; j < n; j++) {

                field.add(new Button("O"),i,j);

            }
        }

        return field;


    }

}
