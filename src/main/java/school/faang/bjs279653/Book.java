package school.faang.bjs279653;

import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return title.equals(b.title) && author.equals(b.author) && year == b.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

}
