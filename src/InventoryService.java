import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("clean-code", 5);
        stock.put("effective-java", 3);
        stock.put("head-first-design-patterns", 0);
    }

    public void reserveBook(String bookId) {
        int availableCopies = stock.getOrDefault(bookId, 0);

        if (availableCopies < 1) {
            throw new IllegalStateException(
                    "Book is currently out of stock: " + bookId);
        }

        stock.put(bookId, availableCopies - 1);
        System.out.println("Inventory: one copy reserved.");
    }

    public void releaseBook(String bookId) {
        stock.put(bookId, stock.getOrDefault(bookId, 0) + 1);
        System.out.println("Inventory: reservation released.");
    }
}
