package school.faang.hashmaplibrary;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Book {
    private final String TITLE;
    private final String AUTHOR;
    private final int YEAR;


    public Book(String TITLE, String AUTHOR, int YEAR) {
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

        Book book = (Book) obj;
        return YEAR == book.YEAR && Objects.equals(TITLE, book.TITLE) && Objects.equals(AUTHOR, book.AUTHOR);
    }
}
