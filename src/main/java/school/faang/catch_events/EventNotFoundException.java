package school.faang.catch_events;

import java.util.NoSuchElementException;

public class EventNotFoundException extends NoSuchElementException {
    public EventNotFoundException(String eventType) {
        super("EVENT TYPE " + eventType + " NOT FOUND");
    }
}
