public class Book {
    private final String title;
    private final double price;

    public Book(String title, double price) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Book price must be positive.");
        }

        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
