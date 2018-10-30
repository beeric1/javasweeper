package mine;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SceneCreator {

    private Stage stage;
    private MineCheck check = new MineCheck();
    public boolean first = true;

    public SceneCreator(Stage stage) {
        this.stage = stage;
    }

    public void createScene(int n) throws Exception{



        //Parent top = FXMLLoader.load(getClass().getResource("top.fxml"));
        //Parent bottom = FXMLLoader.load(getClass().getResource("bottom.fxml"));

        FXMLLoader loaderTop = new FXMLLoader(getClass().getResource("top.fxml"));
        FXMLLoader loaderBottom = new FXMLLoader(getClass().getResource("bottom.fxml"));
        Parent top = (Parent)loaderTop.load();
        Parent bottom = (Parent)loaderBottom.load();

        TopController controllerTop = (TopController)loaderTop.getController();
        BottomController controllerBottom = (BottomController)loaderBottom.getController();

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
                check.mineNr = 20;
                break;
            case 20:
                check.mineNr = 30;
                break;
            default:
                check.mineNr = 40;
        }
        check.mineNr = 10;
        check.hSize = n;
        check.vSize = n;



        GridPane field = new GridPane();


        for (int i = 0; i <n ; i++) {

            for (int j = 0; j < n; j++) {

                Button button = new Button("  ");
                button.setPrefHeight(1);
                button.setPrefWidth(1);
                button.setOnMouseClicked(e -> {
                    if(e.isShiftDown()){
                        if(((Button)e.getSource()).getText().equals("O")){
                            ((Button)e.getSource()).setText("F");
                        }else {
                            ((Button)e.getSource()).setText("O");
                        }

                    }else {
                        int x = GridPane.getRowIndex((Node) e.getSource());
                        int y = GridPane.getColumnIndex((Node) e.getSource());

                        if(first){
                            check.createField(y,x);
                            first = false;
                        }

                        //get stuff to display

                        Integer result =  check.field[y][x];
                        ((Button)e.getSource()).setText(result.toString());
                    }


                });
                field.add(button,i,j);

            }
        }

        return field;

    }

}
