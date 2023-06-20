package middleearth.exception;

public class InventoryLimitIsExceededException extends RuntimeException {
    public InventoryLimitIsExceededException() {
    }

    public InventoryLimitIsExceededException(String message) {
        super(message);
    }
}
