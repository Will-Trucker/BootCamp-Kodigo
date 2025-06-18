package strategy;
// estrategia para el pago con paypal
public class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay(double monto){
        System.out.println("Pago de $ " + monto + " realizado por Paypal");
    }
}
