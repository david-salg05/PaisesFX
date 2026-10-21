
package com.example.priimerproyecto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    //ArrayList que guarda los paises registrados
    ArrayList<String> paises = new ArrayList<>();

    public void guardarDatos(ActionEvent actionEvent) {

        //Variables
        String[] cont = {"America", "Europa", "Asia", "Africa", "Oceania", "Antartida"};
        boolean esCorrecto = true, continenteValido = false;
        int pobl = 0;
        String errores = "";

        //Limpio el label de error
        error.setText("");

        //Compruebo que el pais aun no esta registrado
        for (String pais : paises) {
            if (pais.equalsIgnoreCase(nombrePais.getText())) {
                errores += "Error, país ya registrado!\n";
                esCorrecto = false;
            }
        }

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
            errores += "El continente no es valido\n";
            esCorrecto = false;
        }

        //Si todos los datos son correctos, los guardo en el fichero binario y guardo el nuevo pais en el arrayList
        if (esCorrecto) {
            paises.add(nombrePais.getText());
            error.setText("País guardado correctamente");
        } else {
            error.setText(errores);
        }
    }
}
