package bjs2_33093;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }
}
