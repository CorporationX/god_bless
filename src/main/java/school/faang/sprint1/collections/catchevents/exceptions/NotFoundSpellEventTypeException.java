package school.faang.sprint1.collections.catchevents.exceptions;

public class NotFoundSpellEventTypeException extends RuntimeException {
    public NotFoundSpellEventTypeException(String message, String eventType) {
        super(String.format(message, eventType));
    }
}
