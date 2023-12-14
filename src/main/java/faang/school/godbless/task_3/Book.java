package faang.school.godbless.task_3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Book {
    private String tittle;
    private String author;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(tittle, book.tittle) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, author, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
