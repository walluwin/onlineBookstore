public class OnlineBookstoreFacade {
    private final CatalogService catalogService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final DeliveryService deliveryService;

    public OnlineBookstoreFacade() {
        this.catalogService = new CatalogService();
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.orderService = new OrderService();
        this.deliveryService = new DeliveryService();
    }

    public String placeOrder(String customerName, String bookId, String address) {
        Book book = catalogService.findBook(bookId);
        inventoryService.reserveBook(bookId);

        boolean paymentCompleted = false;
        try {
            paymentCompleted = paymentService.processPayment(
                    customerName, book.getPrice());

            String orderId = orderService.createOrder(customerName, book);
            deliveryService.arrangeDelivery(orderId, address);

            System.out.println("Facade: order completed successfully.");
            return orderId;
        } catch (RuntimeException exception) {
            inventoryService.releaseBook(bookId);

            if (paymentCompleted) {
                paymentService.refundPayment(book.getPrice());
            }

            throw new IllegalStateException(
                    "Could not complete the order: " + exception.getMessage(),
                    exception);
        }
    }
}
