public class Operacion {
    private String type;
    private double resultado;



    public Operacion(String type, double resultado){
        this.type = type;
        this.resultado = resultado;
    }

    public String getType(){
        return type;
    }

    public double getResultado(){
        return resultado;
    }


}
