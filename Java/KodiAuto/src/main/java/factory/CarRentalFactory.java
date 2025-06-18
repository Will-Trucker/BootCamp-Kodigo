package factory;

// Para crear las instancias de los autos
public class CarRentalFactory {
    public static CarRental createCar(String type){
        if(type == null){
            throw new IllegalArgumentException("El tipo Auto es requerido");
        }

        switch (type.toLowerCase()){
            case "economy":
                return new EconomyCar();
            case "luxury":
                return new LuxuryCar();
            case "offroad":
                return new OffRoadCar();
            default:
                throw new IllegalArgumentException("Auto no valido " + type);
        }
    }
}
