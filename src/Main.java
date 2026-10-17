public class Main {
    public static void main(String[] args) {
        OnlineBookstoreFacade bookstore = new OnlineBookstoreFacade();

        System.out.println("=== Online Bookstore ===");
        try {
            String orderId = bookstore.placeOrder(
                    "Alex", "clean-code", "Astana, Kazakhstan");
            System.out.println("Your order number: " + orderId);
        } catch (RuntimeException exception) {
            System.out.println("Order failed: " + exception.getMessage());
        }

        System.out.println();
        System.out.println("=== Try to order an unavailable book ===");
        try {
            bookstore.placeOrder(
                    "Alex", "head-first-design-patterns", "Astana, Kazakhstan");
        } catch (RuntimeException exception) {
            System.out.println("Order failed: " + exception.getMessage());
        }
    }
}
