package factory;
// Interfaz base para todos los tipos de autos
// clase concreta
public class EconomyCar implements CarRental{
    @Override
  public String getDescripcion(){
      return "Auto Sedán";
  }
}
