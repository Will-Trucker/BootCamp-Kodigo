package decorator;

import factory.CarRental;

public class InsuranceDecorator extends CarRentalDecorator{
    public InsuranceDecorator(CarRental rental){
        super(rental);
    }

    public String getDescripcion(){
        return rental.getDescripcion() + " + Seguro";
    }
}
