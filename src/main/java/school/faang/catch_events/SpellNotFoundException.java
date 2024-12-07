package school.faang.catch_events;

import java.util.NoSuchElementException;

public class SpellNotFoundException extends NoSuchElementException {
    private static final String INCORRECT_SPELL = "SPELL NOT FOUND";

    public SpellNotFoundException(int id) {
        super(INCORRECT_SPELL + " " + id);
    }
}
