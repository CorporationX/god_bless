package faang.school.godbless.westeroslib;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private int year;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle())
               && Objects.equals(getAuthor(), book.getAuthor())
               && getYear() == book.getYear();
    }

    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
