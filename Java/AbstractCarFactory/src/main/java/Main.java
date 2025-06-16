public class Main {
    public static void main(String[] args){
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory motorcycleFactory = new MotorcycleFactory();

        // Pedidos del cliente a traves de la interface y clases abstractas
        Vehicle car = carFactory.createVehicle();
        Vehicle moto = motorcycleFactory.createVehicle();

        // Testing
        car.drive();
        moto.drive();

    }
}
