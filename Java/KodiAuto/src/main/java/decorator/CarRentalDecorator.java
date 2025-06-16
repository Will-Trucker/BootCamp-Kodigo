package decorator;

import factory.CarRental;

public abstract class CarRentalDecorator implements CarRental{
    protected CarRental rental;

    public CarRentalDecorator(CarRental rental){
        this.rental = rental;
    }
}
