package observer;

import java.util.ArrayList;
import java.util.List;
// Encargado de notificar a los observadores(cliente, etc.)
public class ReservationNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObservers(Observer o){
        observers.add(o);
    }

    public void notifyAllObservers(String mensaje) {
        for(Observer o : observers) o.update(mensaje);
    }
}
