
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
        System.out.println("¿Desea Solicitar una Reserva ? - (Si/No)");
        String response = scanner.nextLine();
        if(response.equalsIgnoreCase("si")){
            System.out.println("Ingrese el modelo del auto: ");
            String carModel = scanner.nextLine();
            facade.makeReservation(carModel);
        }

        // Factory Method + Decorator: Selección de tipo de auto con validación
        String type = "";
        while(true) {
            System.out.print("Seleccione tipo de auto (economy/luxury/suv): ");
            type = scanner.nextLine();
            if(type.equalsIgnoreCase("economy") ||
                    type.equalsIgnoreCase("luxury") ||
                    type.equalsIgnoreCase("suv")) break;
            System.out.println("Tipo inválido. Intente de nuevo.");
        }

        CarRental car = CarRentalFactory.createCar(type);

        // Decorator: Agregar GPS
        System.out.print("¿Desea GPS? (sí/no): ");
        if(scanner.nextLine().equalsIgnoreCase("sí")) {
            car = new GPSDecorator(car);
        }

        // Decorator: Agregar Seguro
        System.out.print("¿Desea seguro? (sí/no): ");
        if(scanner.nextLine().equalsIgnoreCase("sí")) {
            car = new InsuranceDecorator(car);
        }

        System.out.println("Reserva con extras: " + car.getDescripcion());

        // Builder: Construcción de reserva completa
        ConcreteReservationBuilder builder = new ConcreteReservationBuilder();
        builder.setCarType(type);

        System.out.print("¿Desea GPS para la reserva completa? (sí/no): ");
        if(scanner.nextLine().equalsIgnoreCase("sí")) builder.AddGPS();

        System.out.print("¿Desea seguro para la reserva completa? (sí/no): ");
        if(scanner.nextLine().equalsIgnoreCase("sí")) builder.AddInsurance();

        System.out.println("Reserva Completa (Builder): " + builder.build());

        // Adapter: Uso de servicio de reserva externo (simulado)
        ThirdPartyCarRental thirdParty = new ThirdPartyService();
        ThirdPartyAdapter adapter = new ThirdPartyAdapter(thirdParty);

        System.out.print("Ingrese modelo para reservar con servicio externo: ");
        String externalModel = scanner.nextLine();
        adapter.reserve(externalModel);

        // Strategy: Selección de método de pago
        PaymentStrategy payment;
        while (true) {
            System.out.print("Seleccione método de pago (credit/paypal): ");
            String paymentMethod = scanner.nextLine();
            if(paymentMethod.equalsIgnoreCase("credit")) {
                payment = new CreditPayment();
                break;
            } else if(paymentMethod.equalsIgnoreCase("paypal")) {
                payment = new PaypalPayment();
                break;
            } else {
                System.out.println("Método de pago no válido. Intente de nuevo.");
            }
        }
        payment.pay(200); // Monto fijo simulado

        // Observer: Notificar al cliente
        ReservationNotifier notifier = new ReservationNotifier();
        System.out.print("Ingrese nombre de cliente para notificar: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        notifier.addObservers(customer);
        notifier.notifyAllObservers("¡Su reserva ha sido confirmada!");

        // Command: Ejecutar operación de reserva como comando
        System.out.print("Ingrese modelo para reservar usando Command: ");
        String commandCar = scanner.nextLine();
        Command reserveCommand = new ReserverCarCommand(commandCar);
        ReservationInvoker invoker = new ReservationInvoker();
        invoker.setCommand(reserveCommand);
        invoker.executeCommand();

        System.out.println("---- Gracias Por Elegirnos ----");
        scanner.close();
    }
}
