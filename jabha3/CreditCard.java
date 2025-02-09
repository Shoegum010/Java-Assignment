public class CreditCard implements PaymentMethod{
    public void pay(double amount){
        System.out.println("paid ₹" + "with Credit card.");
    }
}