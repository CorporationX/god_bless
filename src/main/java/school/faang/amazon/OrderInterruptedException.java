package school.faang.amazon;

public class OrderInterruptedException extends RuntimeException {

    public OrderInterruptedException(InterruptedException s) {
        super(s);
    }
}
