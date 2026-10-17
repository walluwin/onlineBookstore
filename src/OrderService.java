import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {
    private final AtomicInteger nextOrderId = new AtomicInteger(1001);

    public String createOrder(String customerName, Book book) {
        String orderId = "ORD-" + nextOrderId.getAndIncrement();
        System.out.println("Order: " + orderId + " created for "
                + customerName + " (" + book.getTitle() + ").");
        return orderId;
    }
}
