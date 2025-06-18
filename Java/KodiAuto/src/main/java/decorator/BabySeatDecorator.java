package decorator;

import factory.CarRental;
// Decorador para añadir una silla de bebe
public class BabySeatDecorator extends CarRentalDecorator{
    public BabySeatDecorator(CarRental rental){
        super(rental);
    }

    @Override
    public String getDescripcion(){
        return rental.getDescripcion() + " + Silla para infante";
    }


}
