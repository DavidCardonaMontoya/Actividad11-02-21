package packSistemaDeFacturacion;

import packElectrodomesticos.Electrodomestico;
import packElectrodomesticos.Nevera;
import packElectrodomesticos.Televisor;
import packLectura.Leer;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.regex.*;

public class Facturacion {

    private ArrayList<Electrodomestico> electrodomesticos;
    private HashMap<String, Double> tablaConsumo;
    private HashMap<String, Double> tablaProcedencia;
    private boolean lecturaCorrecta;

    public Facturacion(String nombre, HashMap<String, Double> tablaConsumo, HashMap<String, Double> tablaProcedencia, String patron){

        Leer archivoVentas = new Leer(nombre);
        archivoVentas.leerTxt();
        ArrayList<String[]> listaVentas = archivoVentas.getContenido();


        this.electrodomesticos = new ArrayList<>();
        this.tablaConsumo = tablaConsumo;
        this.tablaProcedencia = tablaProcedencia;


        lecturaCorrecta = false;
        Pattern patProductos = Pattern.compile(patron);
        if (validarVentas(listaVentas, patProductos, electrodomesticos)){
            lecturaCorrecta = true;
            for (Electrodomestico elect : electrodomesticos){
                if (elect instanceof Nevera){
                    System.out.println("Es una nevera");
                }
                else if (elect instanceof Televisor){
                    System.out.println("Es un televisor");
                }
                else{
                    System.out.println("Es otro electrodoméstico");
                }
            }
        }


    }

    private boolean validarVentas(ArrayList<String[]> listaVentas, Pattern patProd, ArrayList<Electrodomestico> electrodomesticos){
        try{
            String tipoProducto;
            for (int i=1; i<listaVentas.size(); i++){
                tipoProducto = (listaVentas.get(i)[0]).toUpperCase();
                Matcher mat = patProd.matcher(tipoProducto);
                if (mat.matches()){
                    String consumoTipo = listaVentas.get(i)[1].toUpperCase();
                    String procedenciaTipo = listaVentas.get(i)[2].toUpperCase();
                    int longitud = listaVentas.get(i).length;
                    if (tipoProducto.equals("NEV") && longitud == 4){
                        double capacidad = Double.parseDouble(listaVentas.get(i)[3]);
                        if (tablaConsumo.containsKey(consumoTipo) && tablaProcedencia.containsKey(procedenciaTipo) && capacidad>0){
                            Electrodomestico nevera = new Nevera(tipoProducto, consumoTipo, procedenciaTipo, tablaConsumo.get(consumoTipo), tablaProcedencia.get(procedenciaTipo), capacidad);
                            electrodomesticos.add(nevera);
                        }
                        else{
                            System.out.println("Los tipos de consumo o de procedencia no son válidos");
                            return false;
                        }

                    }
                    else if (tipoProducto.equals("TV") && longitud == 5){
                        double capacidad = Double.parseDouble(listaVentas.get(i)[3]);
                        boolean tdt = false;
                        if (listaVentas.get(i)[4].toUpperCase().equals("S"))
                            tdt = true;
                        if (tablaConsumo.containsKey(consumoTipo) && tablaProcedencia.containsKey(procedenciaTipo) && capacidad>0){
                            Electrodomestico televisor = new Televisor(tipoProducto, consumoTipo, procedenciaTipo, tablaConsumo.get(consumoTipo), tablaProcedencia.get(procedenciaTipo), capacidad, tdt);
                            electrodomesticos.add(televisor);
                        }
                        else{
                            System.out.println("Los tipos de consumo o de procedencia no son válidos");
                            return false;
                        }
                    }
                    else if (tipoProducto.equals("OTRO") && longitud == 3){
                        if (tablaConsumo.containsKey(consumoTipo) && tablaProcedencia.containsKey(procedenciaTipo)){
                            Electrodomestico electrodomestico = new Electrodomestico(tipoProducto, consumoTipo, procedenciaTipo, tablaConsumo.get(consumoTipo), tablaProcedencia.get(procedenciaTipo));
                            electrodomesticos.add(electrodomestico);
                        }
                        else{
                            System.out.println("Los tipos de consumo o de procedencia no son válidos");
                            return false;
                        }
                    }
                    else{
                        System.out.println("El tipo de producto o la cantidad de características del mismo no son válidas.");
                        return false;
                    }

                }
                else{
                    System.out.println("El producto ingresado no está regristrado");
                }

            }

        }
        catch (Exception e){
            //e.printStackTrace();
            System.out.println("Hay datos inválidos en el archivo de texto. Corríjalos por favor.");
            return false;
        }
        System.out.println("Número de electrodomésticos: "+electrodomesticos.size());
        return true;
    }

    public void totalizar(){
        double totalTvs = 0, totalNevs = 0, totalOtros = 0;

        for (Electrodomestico x: electrodomesticos)
            if (x instanceof Televisor)
                totalTvs+=x.getPrecio();
            else if (x instanceof Nevera)
                totalNevs+=x.getPrecio();
            else
                totalOtros+=x.getPrecio();
        System.out.println("Total precio de televisores: "+totalTvs+
                "\n"+"Total precio de neveras: "+totalNevs+
                "\n"+"Total precio de otros electrodomésticos: "+totalOtros);
    }

    public ArrayList<Electrodomestico> getElectrodomesticos() {
        return electrodomesticos;
    }

    public boolean isLecturaCorrecta() {
        return lecturaCorrecta;
    }
}
