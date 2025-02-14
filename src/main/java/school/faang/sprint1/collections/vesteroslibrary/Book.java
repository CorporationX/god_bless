package school.faang.sprint1.collections.vesteroslibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.Year;
import java.util.Objects;

@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(@NonNull String title, @NonNull String author, int year) {
        this.title = title;
        this.author = author;
        if (year > 0 && year <= Year.now().getValue()) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("The year must be between 0 and current year");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
