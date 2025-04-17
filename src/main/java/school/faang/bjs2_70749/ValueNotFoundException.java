package school.faang.bjs2_70749;

import java.util.NoSuchElementException;

public class ValueNotFoundException extends NoSuchElementException {
    public ValueNotFoundException() {
        super("value not found");
    }
}
