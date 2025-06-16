package observer;

import java.util.ArrayList;
import java.util.List;

public class ReservationNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObservers(Observer o){
        observers.add(o);
    }

    public void notifyAllObservers(String mensaje) {
        for(Observer o : observers) o.update(mensaje);
    }
}
