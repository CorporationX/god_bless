package school.faang.bjs2_68795.amazon_warehouse.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String message, Object... args) {
        super(ExceptionMessageFormatter.format(message, args));
    }
}