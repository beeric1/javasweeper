package mine;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SceneCreator {

    private Stage stage;
    private MineCheck check = new MineCheck();
    public boolean first = true;
    private int uncoverd = 0;
    private int fieldsToUncover;

    public SceneCreator(Stage stage) {
        this.stage = stage;
    }
    private TopController controllerTop;
    private BottomController controllerBottom;

    public void createScene(int n) throws Exception{

        //Parent top = FXMLLoader.load(getClass().getResource("top.fxml"));
        //Parent bottom = FXMLLoader.load(getClass().getResource("bottom.fxml"));

        FXMLLoader loaderTop = new FXMLLoader(getClass().getResource("top.fxml"));
        FXMLLoader loaderBottom = new FXMLLoader(getClass().getResource("bottom.fxml"));
        Parent top = (Parent)loaderTop.load();
        Parent bottom = (Parent)loaderBottom.load();

        controllerTop = (TopController)loaderTop.getController();
        controllerTop.n = n;
        controllerBottom = (BottomController)loaderBottom.getController();
        controllerBottom.setMines(n);

        controllerTop.setCreator(this);

        BorderPane border = new BorderPane();
        border.setTop(top);
        border.setBottom(bottom);

        //create field
        border.setCenter(addButtons(n));

        Scene scene = new Scene(border);

        stage.setScene(scene);

        }


    public GridPane addButtons(int n){

        switch(n){
            case 10:
                check.mineNr = 10;
                break;
            case 20:
                check.mineNr = 30;
                break;
            default:
                check.mineNr = 40;
        }

        check.hSize = n;
        check.vSize = n;

        GridPane field = new GridPane();


        for (int i = 0; i <n ; i++) {

            for (int j = 0; j < n; j++) {

                Button button = new Button("  ");
                button.setOnMouseClicked(e -> {
                    if(e.isShiftDown()){
                        if(((Button)e.getSource()).getText().equals("  ")){
                            ((Button)e.getSource()).setText("F");
                            controllerBottom.minesMinus();
                        }else {
                            ((Button)e.getSource()).setText("  ");
                            controllerBottom.minesPlus();
                        }

                    }else {
                        int x = GridPane.getRowIndex((Node) e.getSource());
                        int y = GridPane.getColumnIndex((Node) e.getSource());

                        if(first){
                            check.createField(x,y);
                            fieldsToUncover = (n * n) - check.mineNr;
                            first = false;
                        }

                        //get stuff to display

                        Integer result =  check.field[x][y];
                        if(((Button)e.getSource()).getText().equals("  ") ||((Button)e.getSource()).getText().equals("F")){
                            uncoverd++;
                        }
                        ((Button)e.getSource()).setText(result.toString());

                        if(result.equals(9)){
                            //game over
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Game Over");
                            // Header Text: null
                            alert.setHeaderText(null);
                            alert.setContentText("You lost. Try again!");
                            alert.showAndWait();
                        }else {

                            if(fieldsToUncover == uncoverd){
                                //gewonnen
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Victory");
                                // Header Text: null
                                alert.setHeaderText(null);
                                alert.setContentText("You win!");
                                alert.showAndWait();
                            }
                        }
                    }


                });

                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                field.add(button,i,j);

            }
        }

        return field;

    }

}
