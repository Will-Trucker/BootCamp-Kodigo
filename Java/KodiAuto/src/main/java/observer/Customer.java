package observer;

import java.util.List;
import java.util.ArrayList;

public class Customer implements Observer{
    private String name;
    public Customer(String name){
        this.name = name;
    }

    @Override
    public void update(String mensaje) {
        System.out.println(name + " recibio una notificación: " + mensaje);
    }
}
