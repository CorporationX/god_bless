package school.faang.sprint1.collections.catchevents.exceptions;

public class NotFoundSpellEventTypeException extends RuntimeException {
    public NotFoundSpellEventTypeException(String message) {
        super(message);
    }

    public NotFoundSpellEventTypeException(String message, int id) {
        super(message + " " + id);
    }
}
