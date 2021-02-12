package packLectura;

import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Leer {

    private String nombre;
    private ArrayList<String[]> contenido;

    public Leer(String nombre){
        this.nombre = nombre;
        contenido = new ArrayList<String[]>();
    }

    public void leerTxt(){
        try {
            File archivo = new File(nombre);
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String[] linea = lector.nextLine().split("\\s+");
                contenido.add(linea);
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace(); // Para saber tipo de error y dónde ocurrió
        }
    }

    public ArrayList<String[]> getContenido() {
        return contenido;
    }

}
