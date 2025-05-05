import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    // Metodo para sumar
    public double sumar(Numero a, Numero b){
       return a.getValor() + b.getValor();
    }

    // Metodo para restar
    public double restar(Numero a, Numero b){
        return a.getValor() - b.getValor();
    }

    // Metodo para multiplicar
    public double multiplicar(Numero a, Numero b){
        return a.getValor() * b.getValor();
    }

    // Metodo para division
    public double division(Numero a, Numero b) throws ArithmeticException{
        if(b.getValor() == 0){
            throw new ArithmeticException("Error: Division por Cero no es valida!!");
        }

        return a.getValor() / b.getValor();
    }

    // Metodo para potencia
    public double potencia(Numero natural, Numero exponente){
        return Math.pow(natural.getValor(), exponente.getValor());
    }

    // Metodo para raiz cuadrada
    public double raizCuadrada(Numero a) throws IllegalArgumentException{
        if(a.getValor() < 0){
            throw new IllegalArgumentException("Error: No se puede calcular la raiz indicada");
        }

        return Math.sqrt(a.getValor());
    }
}
