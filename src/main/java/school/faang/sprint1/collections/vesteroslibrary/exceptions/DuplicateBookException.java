package school.faang.sprint1.collections.vesteroslibrary.exceptions;

public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException(String message, String bookTitle) {
        super(String.format(message, bookTitle));
    }
}
