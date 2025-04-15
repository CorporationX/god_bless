package school.faang.bjs2_68833;

import java.util.NoSuchElementException;

public class BookingNotFoundException extends NoSuchElementException {
    public BookingNotFoundException(String msg) {
        super(msg);
    }
}
