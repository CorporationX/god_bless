package school.faang.bjs2_68795.amazon_warehouse;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String message, Object... args) {
        super(MessageFormatter.format(message, args));
    }
}