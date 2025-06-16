package builder;

public interface ReservationBuilder {
    void setCarType(String carType);
    void AddGPS();
    void AddInsurance();
    Reservation build();
}
