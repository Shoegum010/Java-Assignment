public class PayPal implements PaymentMethod{
    public void pay(double amount){
        system.out.println("paid ₹" + amount + "using Paypal.")
    }
}