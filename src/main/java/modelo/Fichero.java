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

    //Funcion que lista los paises que tengo en el fichero
    public static void listadoPaises() throws IOException {

        FileInputStream fis = new FileInputStream(ruta);
        DataInputStream dis = new DataInputStream(fis);

        //debemos leer en el mismo orden que escribimos
        while(true){
            try {
                System.out.print(dis.readUTF() + " ");
                System.out.print(dis.readInt()+ " ");
                System.out.print(dis.readUTF() + " ");
                System.out.print(dis.readUTF() + " ");
                System.out.print(dis.readUTF() + " ");
                System.out.println();
            } catch (IOException e) {
                System.out.println("\nFin fichero\n");
                break;
            }
        }
        dis.close();
        fis.close();
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
}
