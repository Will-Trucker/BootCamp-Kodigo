package decorator;

import factory.CarRental;
// Decorador base para añadir extras sin modificar clases originales
public abstract class CarRentalDecorator implements CarRental{
    protected CarRental rental;

    public CarRentalDecorator(CarRental rental){
        this.rental = rental;
    }

    @Override
    public String getDescripcion(){
        return rental.getDescripcion();
    }
}
