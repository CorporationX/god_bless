package school.faang.bjs279653;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Book {
    private String title;
    private String autor;
    private int year;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;

        return year == book.year && Objects.equals(title, book.title) && Objects.equals(autor, book.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, autor, year);
    }

    @Override
    public String toString() {
        return "Название: " + title + ". Автор: " + autor + ". Год издания: " + year + ". ";
    }
}
