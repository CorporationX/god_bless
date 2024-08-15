package faang.school.godbless.BJS2_19627;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Book)) return false;
        Book book = (Book) obj;
        if (year != book.year) return false;
        if (this.title == null) {
            if (book.title != null) return false;
        }
        if (this.author == null) {
            if (book.author != null) return false;
        }
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}


