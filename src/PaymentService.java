public class PaymentService {
    public boolean processPayment(String customerName, double amount) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }

        System.out.printf("Payment: received %.2f KZT from %s.%n",
                amount, customerName);
        return true;
    }

    public void refundPayment(double amount) {
        System.out.printf("Payment: refund of %.2f KZT processed.%n", amount);
    }
}
