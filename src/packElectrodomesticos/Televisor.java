package packElectrodomesticos;

public class Televisor extends Electrodomestico {

    private double tamanio;
    private boolean tdt;

    public Televisor(String tipoProducto, String tipoConsumo, String tipoProcendencia, double valorC, double valorP, double tamanio, boolean tdt){
        super(tipoProducto, tipoConsumo, tipoProcendencia, valorC, valorP);
        this.tamanio = tamanio;
        this.tdt = tdt;
        actualizarPrecio();
    }

    public void actualizarPrecio() {
        if (tamanio>40)
            precio += precio*0.3;
        if (tdt)
            precio += 250000;
    }
}
