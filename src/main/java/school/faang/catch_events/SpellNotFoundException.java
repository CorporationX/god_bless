package school.faang.catch_events;

import java.util.NoSuchElementException;

public class SpellNotFoundException extends NoSuchElementException {
    public SpellNotFoundException(int id) {
        super("SPELL WITH ID " + id + " NOT FOUND");
    }
}
