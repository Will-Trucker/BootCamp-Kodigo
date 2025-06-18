package decorator;

import factory.CarRental;
// Decorador para añadir conductor extra
public class AdditionalDriverDecorator extends CarRentalDecorator{
    public AdditionalDriverDecorator(CarRental rental){
        super(rental);
    }

    @Override
    public String getDescripcion() {
        return rental.getDescripcion() + " + Conductor adicional";
    }

}
