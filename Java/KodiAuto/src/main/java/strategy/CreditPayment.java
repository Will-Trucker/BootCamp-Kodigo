package strategy;

public class CreditPayment implements PaymentStrategy{
    @Override
    public void pay(double monto){
        System.out.println("Pago de $ " + monto + " realizado con Tarjeta de Crédito");
    }
}
