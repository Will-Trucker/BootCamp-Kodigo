public class MotorcycleFactory extends VehicleFactory{
    @Override
    public Vehicle createVehicle(){
        return new Motorcycle();
    }
}
