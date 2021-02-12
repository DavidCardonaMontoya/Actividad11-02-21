package packElectrodomesticos;

public class Nevera extends Electrodomestico {

    private double tamanio;

    public Nevera(String tipoProducto, String tipoConsumo, String tipoProcendencia, double valorC, double valorP, double tamanio){
        super(tipoProducto, tipoConsumo, tipoProcendencia, valorC, valorP);
        this.tamanio = tamanio;
        actualizarPrecio();
    }

    public void actualizarPrecio() {
        int exceso = (int)((tamanio-120)/10);
        if (exceso>0)
            precio += 0.05*exceso*precio;
    }
}
