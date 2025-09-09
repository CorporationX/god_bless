package school.faang.bjs2_86060;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Year;

@EqualsAndHashCode
@ToString
@Getter
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);

        this.title = title;
        this.author = author;
        this.year = year;
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не должно быть пустым");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
    }

    private void validateYear(int year) {
        int currentYear = Year.now().getValue();
        if (year <= 0 || year > currentYear) {
            throw new IllegalArgumentException("Некорректный год издания: " + year);
        }
    }
}
