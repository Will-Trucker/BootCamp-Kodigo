package builder;

public class Reservation {
    private String carType;
    private boolean gps;
    private boolean insurance;

    // constructor

    public Reservation(String carType, boolean gps, boolean insurance) {
        this.carType = carType;
        this.gps = gps;
        this.insurance = insurance;
    }

    public String toString(){
        return "Tipo Auto: " + carType + ", GPS: " + gps + ", Seguro: " + insurance;
    }
}
