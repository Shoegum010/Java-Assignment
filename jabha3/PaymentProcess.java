class PaymentProcess{
    PaymentMethod method;

    PaymentProcess(PaymentMethod method){
        this.method = method;
    }

    void makePayment(double amount){
        method.pay(amount);
    }
}