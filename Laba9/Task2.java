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

public class Task2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button;

    @FXML
    private Button ButtonMenu;

    @FXML
    private TextField TextMothCount;

    @FXML
    void initialize() {
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
          HelloApplication.stageTask2.close();
      });
      Button.setOnAction(actionEvent -> {
          int n=0;
          try {
              n = Integer.parseInt(TextMothCount.getText());
          }catch(Exception ex )
          {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Помилка");
              alert.setHeaderText(null);
              alert.setContentText("Не допустиме значення!");
              TextMothCount.setText("");
              alert.showAndWait();
          }
          String string;
          switch(n) {
              case 1:
                  string = "Cічень";
                  break;
              case 2:
                  string = "Лютий";
                  break;
              case 3:
                  string = "Березень";
                  break;
              case 4:
                  string = "Квітень";
                  break;
              case 5:
                  string = "Травень";
                  break;
              case 6:
                  string = "Червень";
                  break;
              case 7:
                  string = "Липень";
                  break;
              case 8:
                  string = "Серпень";
                  break;
              case 9:
                  string = "Вересень";
                  break;
              case 10:
                  string = "Жовтень";
                  break;
              case 11:
                  string = "Листопад";
                  break;
              case 12:
                  string = "Грудень";
                  break;
              default:
                  string = "Такого місяця немає!";
                  break;
          }
        if(n!=0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Місяць");
            alert.setHeaderText(null);
            alert.setContentText(string);

            alert.showAndWait();
            TextMothCount.setText("");
        }
      });
    }


}
