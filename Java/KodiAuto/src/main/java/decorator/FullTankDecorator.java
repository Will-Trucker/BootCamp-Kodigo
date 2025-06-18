package decorator;

import factory.CarRental;
// Decorador para pedir el vehiculo con tanque lleno
public class FullTankDecorator extends CarRentalDecorator{
    public FullTankDecorator(CarRental rental){
        super(rental);
    }

    @Override
    public String getDescripcion(){
        return rental.getDescripcion() + " + Tanque lleno";
    }
}
