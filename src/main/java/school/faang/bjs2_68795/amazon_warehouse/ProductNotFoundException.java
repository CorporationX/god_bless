package school.faang.bjs2_68795.amazon_warehouse;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message, Object... args) {
        super(MessageFormatter.format(message, args));
    }
}