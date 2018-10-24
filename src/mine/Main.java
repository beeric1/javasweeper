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

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent top = FXMLLoader.load(getClass().getResource("top.fxml"));
        Parent bottom = FXMLLoader.load(getClass().getResource("bottom.fxml"));

        BorderPane border = new BorderPane();
        border.setTop(top);
        border.setBottom(bottom);

        //create field
        border.setCenter(addButtons(8));

        primaryStage.setTitle("JavaSweeper");
        primaryStage.setScene(new Scene(border, 400, 500));

        controller = new Controller();

        controller.addButtons(10);




        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public GridPane addButtons(int n){

        GridPane field = new GridPane();

        for (int i = 0; i <n ; i++) {

            for (int j = 0; j < n; j++) {

                Button button = new Button("O");
                button.setOnMouseClicked(e -> {
                    if(e.isShiftDown()){
                        if(((Button)e.getSource()).getText().equals("O")){
                            ((Button)e.getSource()).setText("F");
                        }else {
                            ((Button)e.getSource()).setText("O");
                        }

                    }else {
                        ((Button)e.getSource()).setText("Y");
                    }

                    GridPane.getRowIndex((Node) e.getSource());
                    GridPane.getColumnIndex((Node) e.getSource());
                });
                field.add(button,i,j);

            }
        }

        return field;

    }
}
