package adapter;

public class ThirdPartyService implements ThirdPartyCarRental {
    public void bookCar(String model){
        System.out.println("Reserva realizada con servicio adicional: " + model);
    }
}
