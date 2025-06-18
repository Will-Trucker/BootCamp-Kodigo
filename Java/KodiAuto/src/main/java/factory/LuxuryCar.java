package factory;
// Interfaz base para todos los tipos de autos
// clase concreta
public class LuxuryCar implements CarRental{
    @Override
    public String getDescripcion() {
        return "Auto Lujoso";
    }
}
