package com.example.pr2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextY;
    @FXML
    public Button Button1;
    @FXML
    private TextField TextZ;

    @FXML
    private TextField TexxtX;

    @FXML public void ButtonK()
    {
        int x,y,z;
        try
        {
            x=Integer.parseInt(TexxtX.getText());
            y=Integer.parseInt(TextY.getText());
            z=Integer.parseInt(TextZ.getText());
            int n=(x*x*y-(14*z));
            double a=  Math.sqrt(n);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Результат");
            alert.setHeaderText(null);
            alert.setContentText(Double.toString(a));
            alert.show();
        }catch(Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Помилка!");
            alert.setHeaderText(null);
            alert.setContentText("Подивись краще!!!!");
            alert.show();
        }
    }

}
