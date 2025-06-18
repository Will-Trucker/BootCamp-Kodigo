// importacion de clases externas
import facade.ReservationFacade;
import factory.*;
import decorator.*;
import observer.Customer;
import observer.ReservationNotifier;
import strategy.*;
import  command.*;
import adapter.*;
import builder.*;

import java.util.Scanner;

/**
 * Sistema de Alquiler de Autos que implementa patrones de diseño:
 * Singleton, Factory Method, Builder, Adapter, Facade, Decorator, Strategy, Observer, Command.
 * Permite realizar reservas de autos con selección de tipo, extras, método de pago y notificaciones.
 */

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- KODI AUTOS ----");

        // uso de instancia unica de reserva
        ReservationFacade facade = new ReservationFacade();
        System.out.println("****************************************");
        System.out.println("                                        ");
        System.out.println("¿Desea Solicitar una Reserva ? - (Si/No)");
        System.out.println("                                        ");
        System.out.println("****************************************");
        String response = scanner.nextLine();

        if(response.equalsIgnoreCase("si")) {
            // Factory: Selección tipo de auto
            String type;
            while (true) {
                System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
                System.out.print("Seleccione tipo de auto (economy/luxury/suv): ");
                System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
                type = scanner.nextLine();
                if(type.equalsIgnoreCase("economy") ||
                        type.equalsIgnoreCase("luxury") ||
                        type.equalsIgnoreCase("suv")) break;
                System.out.println("Tipo inválido. Intente de nuevo.");
            }
            CarRental car = CarRentalFactory.createCar(type);

            // Decorator: Extras
            System.out.println("*******************************************");
            System.out.println("                                           ");
            System.out.print("¿Desea agregar Conductor adicional? (si/no): ");
            System.out.println("                                           ");
            System.out.println("*******************************************");
            if(scanner.nextLine().equalsIgnoreCase("si")) {
                car = new AdditionalDriverDecorator(car);
            }

            System.out.println("*******************************************");
            System.out.println("                                           ");
            System.out.print("   ¿Desea agregar Silla para bebé? (si/no):  ");
            System.out.println("                                           ");
            System.out.println("*******************************************");
            if(scanner.nextLine().equalsIgnoreCase("si")) {
                car = new BabySeatDecorator(car);
            }

            System.out.println("*******************************************");
            System.out.println("                                           ");
            System.out.print("     ¿Desea agregar Tanque lleno? (si/no):   ");
            System.out.println("                                           ");
            System.out.println("*******************************************");
            if(scanner.nextLine().equalsIgnoreCase("si")) {
                car = new FullTankDecorator(car);
            }


            System.out.println("*******************************************");
            System.out.println("Reserva con extras: " + car.getDescripcion());
            System.out.println("*******************************************");
            // Builder Para construir la reservar
            ConcreteReservationBuilder builder = new ConcreteReservationBuilder();
            builder.setCarType(type);
            Reservation fullReservation = builder.build();
            System.out.println("-----------------------------------------------");
            System.out.println("Reserva Completa: " + fullReservation);
            System.out.println("-----------------------------------------------");
            // Strategy: Metodos de pago aceptados
            PaymentStrategy payment;
            while (true) {
                System.out.println("-----------------------------------------------");
                System.out.print("Seleccione método de pago (credit/paypal):       ");
                System.out.println("-----------------------------------------------");
                String payMethod = scanner.nextLine();
                if (payMethod.equalsIgnoreCase("credit")) {
                    payment = new CreditPayment();
                    break;
                } else if (payMethod.equalsIgnoreCase("paypal")) {
                    payment = new PaypalPayment();
                    break;
                } else {
                    System.out.println("Método no válido.");
                }
            }
            payment.pay(200);

            // Observer: Para enviar la notificacion al cliente
            System.out.println("-----------------------------------------------");
            System.out.print("Ingrese nombre del cliente para notificación:    ");
            System.out.println("-----------------------------------------------");
            String customerName = scanner.nextLine();
            ReservationNotifier notifier = new ReservationNotifier();
            notifier.addObservers(new Customer(customerName));
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            notifier.notifyAllObservers("  ¡Su reserva ha sido confirmada!       ");
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            // Command Para la reservacion
            Command reserveCommand = new ReserverCarCommand(type);
            ReservationInvoker invoker = new ReservationInvoker();
            invoker.setCommand(reserveCommand);
            invoker.executeCommand();

        } else {
            // No realizar nada si la operacion es falllida
            System.out.println("******************************");
            System.out.println("No se realizó ninguna reserva.");
            System.out.println("******************************");
        }

        System.out.println("---- Gracias Por Elegirnos ----");
        scanner.close();
    }
}
