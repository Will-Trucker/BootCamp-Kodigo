package facade;

import singleton.ReservationSystem;

public class ReservationFacade {
    public void makeReservation(String car){
        ReservationSystem.getInstance().reservarAuto(car);
    }
}
