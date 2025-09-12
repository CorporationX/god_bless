package school.faang.BJS286069;

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
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) {
            return false;
        }
        return getYear() == book.getYear()
            && Objects.equals(getTitle(), book.getTitle())
            && Objects.equals(getAuthor(), book.getAuthor()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getYear());
    }
}
