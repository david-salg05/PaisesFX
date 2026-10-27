package com.example.priimerproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import modelo.Fichero;

import java.io.IOException;

public class TerceraVistaController {

    //Variables
    @FXML
    ComboBox <String> comboBox;

    @FXML
    TextArea textArea;

    @FXML
    public void initialize(){
        comboBox.getItems().addAll("España", "Guinea Ecuatorial", "Portugal", "China", "Samoa");
    }

    String texto = "";

    public void rellenarTextArea(ActionEvent actionEvent) throws IOException {
        String valorComprobar = comboBox.getValue();

        if (!Fichero.consultarPais(valorComprobar)){
            textArea.setText("El país seleccionado no ha sido dado de alta en el fichero");
        }else{
            textArea.setText(Fichero.listarPais(valorComprobar));
        }
    }
}
