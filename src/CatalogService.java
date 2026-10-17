import java.util.HashMap;
import java.util.Map;

public class CatalogService {
    private final Map<String, Book> books = new HashMap<>();

    public CatalogService() {
        books.put("clean-code", new Book("Clean Code", 8500.0));
        books.put("effective-java", new Book("Effective Java", 9200.0));
        books.put("head-first-design-patterns",
                new Book("Head First Design Patterns", 7800.0));
    }

    public Book findBook(String bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            throw new IllegalArgumentException(
                    "Book not found in catalog: " + bookId);
        }

        System.out.println("Catalog: found \"" + book.getTitle() + "\".");
        return book;
    }
}
