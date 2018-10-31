package mine;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class BottomController {

    //Status bar
    @FXML
    private Text mines;

    @FXML
    private Text time;



    public void setMines(int n){
        mines.setText(String.valueOf(n));
    }

    public void minesMinus(){
        int mine = Integer.parseInt(mines.getText());
        mine--;
        setMines(mine);
    }

    public void minesPlus(){
        int mine = Integer.parseInt(mines.getText());
        mine++;
        setMines(mine);
    }

}
