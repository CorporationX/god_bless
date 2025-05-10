package school.faang.bjs2_75964.exception;

public class PromoCodeAlreadyExistsException extends RuntimeException {
    public PromoCodeAlreadyExistsException(String code) {
        super(String.format("Promo code %s already exists", code));
    }
}
