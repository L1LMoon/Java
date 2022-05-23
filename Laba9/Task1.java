package com.example.lb9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Task1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonChenge;

    @FXML
    private TextField TextA;

    @FXML
    private TextField TextB;

    @FXML
    private TextField TextC;
    @FXML
    private Button ButtonMenu;


    @FXML
    void initialize() {
       ButtonChenge.setOnAction(actionEvent -> {
           int A,B,C;
           try {
               A = Integer.parseInt(TextA.getText());
               B = Integer.parseInt(TextB.getText());
               C = Integer.parseInt(TextC.getText());
               TextA.setText(String.valueOf(C));TextB.setText(String.valueOf(A));TextC.setText(String.valueOf(B));
           }catch(Exception ex)
           {
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("Помилка");
               alert.setHeaderText(null);
               alert.setContentText("Не допустиме значення!");
               TextA.setText("");
               TextB.setText("");
               TextC.setText("");

               alert.showAndWait();
           }
       });


        ButtonMenu.setOnAction(actionEvent -> {
            try{
                Stage stage =new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 860, 480);
                stage.setTitle("LB9");
                stage.setScene(scene);
                stage.show();
                HelloApplication.stageMenu=stage;
            }catch (IOException e)
            {

            }
            HelloApplication.stageTask1.close();

        });

    }

}

