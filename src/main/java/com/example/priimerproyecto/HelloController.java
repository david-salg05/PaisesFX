package com.example.priimerproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private String [] nombres = {"Andres", "Pablo"};

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(imprimirNombres());
    }

    public String imprimirNombres(){
        return nombres[0] + " " +  nombres[1] ;  }

    public void pulsarBoton(ActionEvent actionEvent) {
        welcomeText.setText("nelson");
    }
}
