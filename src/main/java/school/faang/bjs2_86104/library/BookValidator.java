package school.faang.bjs2_86104.library;

import school.faang.bjs2_86104.exception.BookNotValidException;

import java.time.LocalDate;

public class BookValidator {
    private BookValidator() {}

    static void validateBook(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new BookNotValidException("book title cannot be null, empty or a space");
        }
        if (author == null || author.isBlank()) {
            throw new BookNotValidException("book author cannot be null, empty or a space");
        }
        if (year <= 0 || year > LocalDate.now().getYear()) {
            throw new BookNotValidException("book year cannot be less than or equal to zero " +
                    "or greater than the current date");
        }
    }
}
