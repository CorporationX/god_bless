package faang.school.godbless.BJS2_542;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

//@EqualsAndHashCode
@AllArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private int year;


    //there are generated equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "title: " + title + ", "+
               "author " + author + ", " +
               "year " + year;
    }
}
