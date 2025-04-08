package school.faang.bjs2_68771;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.NoSuchElementException;

@ToString
@EqualsAndHashCode
public class Book {
    public static final String TITLE_IS_EMPTY = "Не указан заголовок книги";
    public static final String AUTHOR_IS_EMPTY = "Не указан заголовок книги";
    public static final String YEAR_IS_EMPTY = "Не указан заголовок книги";

    private final String title;
    private final String author;
    private final Integer year;

    public Book(String title, String author, Integer year) {
        validateInputData(title, author, year);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    private void validateInputData(String title, String author, Integer year) {
        StringBuilder error = new StringBuilder();
        if (title == null || title.isBlank()) {
            appendError(error, TITLE_IS_EMPTY);
        }
        if (author == null || author.isBlank()) {
            appendError(error, AUTHOR_IS_EMPTY);
        }
        if (year == null) {
            appendError(error, YEAR_IS_EMPTY);
        }
        if (!error.isEmpty()) {
            throw new NoSuchElementException(error.toString());
        }
    }

    private void appendError(StringBuilder error, String errorMessage) {
        if (!error.isEmpty()) {
            error.append(" ");
        }
        error.append(errorMessage);
    }
}
