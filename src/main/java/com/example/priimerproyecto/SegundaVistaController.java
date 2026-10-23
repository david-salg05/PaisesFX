
package com.example.priimerproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.Fichero;

import java.io.IOException;
import java.util.ArrayList;

public class SegundaVistaController {

    //Inicializacion de variables
    @FXML
    TextField nombrePais;

    @FXML
    TextField poblacion;

    @FXML
    TextField idioma;

    @FXML
    TextField moneda;

    @FXML
    TextField continente;

    @FXML
    Label error;


    public void guardarDatos(ActionEvent actionEvent) throws IOException {

        //Variables
        String[] cont = {"America", "Europa", "Asia", "Africa", "Oceania", "Antartida"};
        boolean esCorrecto = true, continenteValido = false;
        int pobl = 0;
        String errores = "";

        //Limpio el label de error
        error.setText("");

        //Compruebo que la poblacion sea un numero
        try {
            pobl = Integer.parseInt(poblacion.getText());

            if (pobl < 0) {
                errores += "La poblacion no puede ser negativa\n";
                esCorrecto = false;
            }
        } catch (NumberFormatException e) {
            errores += "La población debe ser un valor numérico\n";
            esCorrecto = false;
        }

        //Compruebo la longitud del idioma
        if (idioma.getLength() < 3) {
            errores += "El idioma introducido no es correcto\n";
            esCorrecto = false;
        }

        //Compruebo la longitud de la moneda
        if (moneda.getLength() < 2) {
            errores += "La moneda introducida no es correcta\n";
            esCorrecto = false;
        }

        //Compruebo que el continente sea valido
        for (String c : cont) {
            if (c.equalsIgnoreCase(continente.getText())) {
                continenteValido = true;
                break;
            }
        }

        if (!continenteValido) {
            errores += "El continente no es válido\n";
            esCorrecto = false;
        }

        if(esCorrecto){
            //Compruebo que el pais aun no esta registrado
            if(Fichero.consultarPais(nombrePais.getText().trim())){
                errores += "El país que intentas introducir ya está registrado\n";
                esCorrecto = false;
            }
        }

        //Si todos los datos son correctos, los guardo en el fichero binario y guardo el nuevo pais en el arrayList
        if (esCorrecto) {
            error.setText("País guardado correctamente");
            Fichero.altaPais(nombrePais.getText().trim(), pobl, idioma.getText(), moneda.getText(), continente.getText());
            nombrePais.setText("");
            poblacion.setText("");
            idioma.setText("");
            moneda.setText("");
            continente.setText("");
        } else {
            error.setText(errores);
        }
    }
}
