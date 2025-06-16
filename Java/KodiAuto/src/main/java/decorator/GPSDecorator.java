package decorator;


import factory.CarRental;

public class GPSDecorator extends CarRentalDecorator {
    public GPSDecorator(CarRental rental){
        super(rental);
    }

    public String getDescripcion(){
        return rental.getDescripcion() + " + GPS";
    }
}
