package packCriterios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Criterio {

    private HashMap<String, Double> criterio;
    private Pattern pat;
    private ArrayList<String[]> texto;

    public Criterio(ArrayList<String[]> texto,Pattern pat){
        this.criterio = new HashMap<>();
        this.pat = pat;
        this.texto = texto;
        if (!validar())
            System.out.println("Hay datos inválidos en el archivo de texto. Corríjalos por favor.");
    }

    public boolean validar(){
        try{
            for (String[] linea : texto){
                Matcher mat = pat.matcher(linea[0]);
                if (linea.length == 2 && mat.matches())
                    criterio.put(linea[0].toUpperCase(), Double.parseDouble(linea[1]));
            }
        }
        catch (Exception e){
            //e.printStackTrace();
            return false;
        }
        return true;
    }

    public HashMap<String, Double> getCriterio() {
        return criterio;
    }
}
