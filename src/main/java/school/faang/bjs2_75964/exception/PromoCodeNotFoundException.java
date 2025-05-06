package school.faang.bjs2_75964.exception;

import java.util.NoSuchElementException;

public class PromoCodeNotFoundException extends NoSuchElementException {
    public PromoCodeNotFoundException() {
        super("Proper promo code not found");
    }
}
