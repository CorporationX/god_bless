package school.faang.westeros_library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Book otherBook = (Book) otherObject;
        return this.title.equals(otherBook.getTitle())
                && this.author.equals(otherBook.getAuthor())
                && this.year == otherBook.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

}
