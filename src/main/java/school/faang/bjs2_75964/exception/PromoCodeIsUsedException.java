package school.faang.bjs2_75964.exception;

public class PromoCodeIsUsedException extends RuntimeException {
    public PromoCodeIsUsedException(String code) {
        super(String.format("Promo code %s is used", code));
    }
}
