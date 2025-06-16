package builder;

public class ConcreteReservationBuilder implements ReservationBuilder{
    private String carType;
    private boolean gps;
    private boolean insurance;

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void AddGPS(){
        this.gps = true;
    }

    public void AddInsurance(){
        this.insurance = true;
    }

    public Reservation build(){
        return new Reservation(carType,gps,insurance);
    }

}
