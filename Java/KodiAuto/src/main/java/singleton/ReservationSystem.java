package singleton;

public class ReservationSystem {
    private static ReservationSystem instance;

    private ReservationSystem(){};

    public static ReservationSystem getInstance(){
        if(instance == null){
            instance = new ReservationSystem();
        }
        return instance;
    }

    public void reservarAuto(String car){
        System.out.println("Su Reserva fue realizada para: " + car);
    }

}
