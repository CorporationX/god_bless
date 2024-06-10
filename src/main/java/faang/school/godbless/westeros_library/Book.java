package faang.school.godbless.westeros_library;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@AllArgsConstructor
public class Book {
    String title;
    String author;
    int year;

    @Override
    public int hashCode() {
        return Objects.hash(year, title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return  Objects.equals(year, book.year) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}
