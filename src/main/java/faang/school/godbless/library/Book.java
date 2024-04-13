package faang.school.godbless.library;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Year;

@Getter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private Year year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        return year.equals(book.year);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + year.hashCode();
        return result;
    }
}

