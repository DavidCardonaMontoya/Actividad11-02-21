package packElectrodomesticos;

import java.util.HashMap;

public class Electrodomestico {

    protected String tipoProducto;
    protected String tipoConsumo;
    protected String tipoProcedencia;
    protected double precio;

    public Electrodomestico(String tipoProducto, String tipoConsumo, String tipoProcedencia, double valorProd, double valorProc){
        this.tipoConsumo = tipoConsumo;
        this.tipoProcedencia = tipoProcedencia;
        this.tipoProducto = tipoProducto;
        this.precio = valorProd+valorProc;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getTipoConsumo() {
        return tipoConsumo;
    }

    public String getTipoProcedencia() {
        return tipoProcedencia;
    }

    public double getPrecio() {
        return precio;
    }
}
