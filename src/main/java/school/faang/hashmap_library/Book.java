package school.faang.hashmap_library;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private final String TITLE;
    private final String AUTHOR;
    private final String YEAR;

    public Book(String TITLE, String AUTHOR, String YEAR) {
        this.TITLE = TITLE;
        this.AUTHOR = AUTHOR;
        this.YEAR = YEAR;
    }


    @Override
    public int hashCode() {
        return Objects.hash(TITLE, AUTHOR, YEAR);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book)obj;
        return YEAR == book.YEAR && Objects.equals(TITLE, book.TITLE) && Objects.equals(AUTHOR,book.AUTHOR);
    }
}
