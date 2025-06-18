package command;
// comando para reservar un carro
public class ReserverCarCommand implements Command{
    private String carModel;

    public ReserverCarCommand(String carModel){
        this.carModel = carModel;
    }

    @Override
    public void execute() {
        System.out.println("Reserva realizada para el modelo: " + carModel);
    }
}
