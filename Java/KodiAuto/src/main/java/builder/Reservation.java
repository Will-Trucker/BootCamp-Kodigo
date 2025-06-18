package builder;
// builder que representa el paso a paso de la reserva
public class Reservation {
    private String carType;
    private boolean gps;
    private boolean insurance;

    // constructor que incluye para el vehiculo por default tipo de auto, gps y seguro

    public Reservation(String carType, boolean gps, boolean insurance) {
        this.carType = carType;
        this.gps = gps;
        this.insurance = insurance;
    }

    public String toString(){
        return "Tipo Auto: " + carType + ", GPS: " + gps + ", Seguro: " + insurance;
    }
}
