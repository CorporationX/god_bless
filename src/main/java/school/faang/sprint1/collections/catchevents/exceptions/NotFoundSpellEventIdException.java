package school.faang.sprint1.collections.catchevents.exceptions;

public class NotFoundSpellEventIdException extends RuntimeException {
    public NotFoundSpellEventIdException(String message, int id) {
        super(String.format(message, id));
    }
}
