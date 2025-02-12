package school.faang.sprint1.collections.vesteroslibrary.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message, String bookTitle) {
        super(String.format(message, bookTitle));
    }
    public BookNotFoundException(String message) {
        super(message);
    }
}
