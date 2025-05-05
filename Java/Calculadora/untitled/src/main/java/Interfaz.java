import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {
    private Scanner scanner;
    private Calculadora calculadora;

    public Interfaz(){
        scanner = new Scanner(System.in);
        calculadora = new Calculadora();
    }

    public void iniciar(){
        while(true){
            // llamar al menu
            mostrarMenu();
            int opcion = obtenerOpc();
            if(opcion == 0){
                System.out.println("Saliendo del programa....");
                break;
            }
            realizarOperacion(opcion);
        }
    }

    private void mostrarMenu(){
        System.out.println("********************************************************");
        System.out.println("                      CALCULADORA                       ");
        System.out.println("********************************************************");
        System.out.println("************************");
        System.out.println("1. Sumar         ");
        System.out.println("2. Resta         ");
        System.out.println("3. Multiplicacion");
        System.out.println("4. División      ");
        System.out.println("5. Potencia      ");
        System.out.println("6. Raíz Cuadrada ");
        System.out.println("0. Salir         ");
        System.out.println("************************");
        System.out.print("** Eliga una Opcion: ");
    }

    private int obtenerOpc(){
        int opc = -1;
        while (opc < 0 || opc > 6) {
            try {
                opc = scanner.nextInt();
                if (opc < 0 || opc > 6) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    System.out.print("Seleccione una opción: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
                System.out.print("Seleccione una opción: ");
            }
        }
        return opc;
    }


    private void realizarOperacion(int opcion){
        try{
            switch(opcion){
                case 1:
                    Numero num1 = validarNumeros("\nIngrese el primer termino: ");
                    Numero num2 = validarNumeros("\nIngrese el segundo termino: ");
                    double resultadoSum = calculadora.sumar(num1 ,num2);
                    mostrarResultado(" Suma: ", resultadoSum);
                    esperarTecla();
                    limpiarConsola();
                    break;
                case 2:
                    num1 = validarNumeros("\nIngrese el primer termino: ");
                    num2 = validarNumeros("\nIngrese el segundo termino: ");
                    double resultadoRest = calculadora.restar(num1 ,num2);
                    mostrarResultado(" Resta: ", resultadoRest);
                    esperarTecla();
                    limpiarConsola();
                    break;
                case 3:
                    num1 = validarNumeros("\nIngrese el primer termino: ");
                    num2 = validarNumeros("\nIngrese el segundo termino: ");
                    double resultadoMult = calculadora.multiplicar(num1,num2);
                    mostrarResultado(" Multiplicacion: ", resultadoMult);
                    esperarTecla();
                    limpiarConsola();
                    break;
                case 4:
                    num1 = validarNumeros("\nIngrese el primer termino: ");
                    num2 = validarNumeros("\nIngrese el segundo termino: ");
                    double resultDiv = calculadora.division(num1,num2);
                    mostrarResultado(" Division",resultDiv);
                    esperarTecla();
                    limpiarConsola();
                    break;
                case 5:
                    Numero natural = validarNumeros("\nIngrese el termino base: ");
                    Numero exponente = validarNumeros("\nIngrese el termino exponente: ");
                    double resultPot = calculadora.potencia(natural, exponente);
                    mostrarResultado(" Potencia: ", resultPot);
                    esperarTecla();
                    limpiarConsola();
                    break;
                case 6:
                    num1 = validarNumeros("\nIngrese el numero: ");
                    double resultadoRaiz = calculadora.raizCuadrada(num1);
                    mostrarResultado(" Raiz Cuadrada: ",resultadoRaiz);
                    esperarTecla();
                    limpiarConsola();
                    break;
                default:
                    System.out.println("\nOpcion no valida, Elija nuevamente");
                    esperarTecla();
            }
        } catch (ArithmeticException | IllegalArgumentException e){
            System.out.println(e.getMessage());
            esperarTecla();
            limpiarConsola();
        }
    }


    private void mostrarResultado(String tipoOperacion, double resultado) {
        System.out.println("\nResultado de la " + tipoOperacion + ": " + resultado);
    }

    private void esperarTecla(){
        System.out.println("\nPresion cualquier tecla para continuar....");
        try{
            System.in.read();
            System.in.skip(System.in.available());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Si falla al ejecuta no usar
    private void limpiarConsola(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // Código ANSI para limpiar consola en Unix/Linux/Mac
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            // Si falla la limpieza, simplemente imprimir múltiples líneas nuevas
            System.out.println("\n".repeat(50));
        }
    }

    // Para validar que inserte numeros validos o campos vacios
    private Numero validarNumeros(String mensaje){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = scanner.nextLine().trim();

                // Validar que no esté vacío
                if (entrada.isEmpty()) {
                    System.out.println("Error: No puede dejar el campo vacío.");
                    continue;
                }

                // Validar que sea un número
                try {
                    double valor = Double.parseDouble(entrada);
                    return new Numero(valor);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }

            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        Interfaz app = new Interfaz();
        app.iniciar();
    }
}
