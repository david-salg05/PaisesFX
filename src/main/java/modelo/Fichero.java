package modelo;

import java.io.*;
import java.util.Scanner;

public class Fichero {

    //Importo el scanner y establezco la ruta del fichero
    static Scanner teclado = new Scanner(System.in);
    static String ruta = "src/main/java/modelo/fichero/paises.bin";

    //Funcion que comprueba si un pais esta dado de alta
    public static boolean consultarPais(String nombre) throws IOException {

        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //debemos leer en el mismo orden que escribimos
        while(true){

            String n = "";

            try {
                n = dis.readUTF();
                dis.readInt();
                dis.readUTF();
                dis.readUTF();
                dis.readUTF();

                if(n.equalsIgnoreCase(nombre)){
                    dis.close();
                    fis.close();

                    return true;
                }
            } catch (IOException e) {
                break;
            }


        }

        dis.close();
        fis.close();

        return false;
    }


    //Funcion que da de alta a un pais en un fichero
    public static void altaPais(String nombre, int poblacion, String idioma, String moneda, String continente) throws IOException {

        FileOutputStream fos = new FileOutputStream(ruta, true);
        DataOutputStream dos = new DataOutputStream(fos);

        //Introduzco los datos en el fichero
        dos.writeUTF(nombre);
        dos.writeInt(poblacion);
        dos.writeUTF(idioma);
        dos.writeUTF(moneda);
        dos.writeUTF(continente);

        //Cierro el fichero
        dos.close();
        fos.close();

        //Imprimo un mensaje final
        System.out.println("\nPaís registrado correctamente\n");
    }

    //Funcion que nos devuelve la informacion de un pais
    public static String listarPais(String valorComprobar) throws IOException {

        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        String devolver = "";

        try {
            while (true) {

                // Leemos los datos del pais en el mismo orden que escribimos
                String nombre = dis.readUTF();
                int poblacion = dis.readInt();
                String idioma = dis.readUTF();
                String moneda = dis.readUTF();
                String continente = dis.readUTF();

                // Comprobamos si es el pais que buscamos
                if (valorComprobar.equalsIgnoreCase(nombre)) {

                    devolver = "Nombre: " + nombre + "\n";
                    devolver += "Poblacion: " + poblacion + "\n";
                    devolver += "Idioma: " + idioma + "\n";
                    devolver += "Moneda: " + moneda + "\n";
                    devolver += "Continente: " + continente;

                    break;
                }
            }

        } catch (EOFException e) {
            System.out.println("Fin de información");
        }

        dis.close();
        fis.close();

        return devolver;
    }
}
