package school.faang.bjs2_68795.amazon_warehouse.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message, Object... args) {
        super(ExceptionMessageFormatter.format(message, args));
    }
}