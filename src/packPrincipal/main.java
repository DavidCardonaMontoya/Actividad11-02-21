package packPrincipal;

import packCriterios.Criterio;
import packSistemaDeFacturacion.Facturacion;
import packLectura.Leer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {

    public static HashMap<String, Double> cargarTabla(String nombre, String pat){
        Scanner nombreArchivo = new Scanner(System.in);
        System.out.println("Introduzca nombre del archivo de criterios de "+nombre+": ");
        Leer archivoCriterio = new Leer(nombreArchivo.nextLine());
        archivoCriterio.leerTxt();
        ArrayList<String[]> listaCriterio = archivoCriterio.getContenido();
        Pattern patCriterio = Pattern.compile(pat);
        Criterio criterio = new Criterio(listaCriterio, patCriterio);
        HashMap<String, Double> tablaCriterio = criterio.getCriterio();
        return tablaCriterio;
    }

    public static void mostrar(HashMap<String, Double> mapa){
        double valor;
        for (String llave: mapa.keySet()){
            valor = mapa.get(llave);
            System.out.println(llave + " " + valor);
        }
    }

    public static void main(String[] args){

        HashMap<String, Double> tablaConsumo = cargarTabla("consumo.txt", "^[abcABC]$" );
        HashMap<String, Double> tablaProcedencia = cargarTabla("procedencia.txt", "^[Ii][Nn][Tt][Ll]|[Nn][Aa][Ll]$" );
        Facturacion facturacion = new Facturacion("input.txt", tablaConsumo, tablaProcedencia, "^[Nn][Ee][Vv]|[Tt][Vv]|[Oo][Tt][Rr][Oo]$");
        if (facturacion.isLecturaCorrecta())
            facturacion.totalizar();
        else
            System.out.println("Ocurrió un error");

    }
}

