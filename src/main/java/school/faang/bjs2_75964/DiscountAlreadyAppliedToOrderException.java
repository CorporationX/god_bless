package school.faang.bjs2_75964;

public class DiscountAlreadyAppliedToOrderException extends RuntimeException {
    public DiscountAlreadyAppliedToOrderException(long number) {
        super(String.format("discount has already been applied to the order %d", number));
    }
}
