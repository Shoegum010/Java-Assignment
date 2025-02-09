public class Main{
    public static void main(String[] args){
        PaymentProcess credit = new PaymentProcess(new CreditCard());
        credit.makePayment(100.0);

        PaymentProcess paypal = new PaymentProcess(new PayPal());
        credit.makePayment(100.0);
    }
}