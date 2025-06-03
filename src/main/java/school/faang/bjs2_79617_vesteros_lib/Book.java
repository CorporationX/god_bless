package school.faang.bjs2_79617_vesteros_lib;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book target = (Book) obj;
        return year == target.year
                && Objects.equals(title, target.title)
                && Objects.equals(author, target.author);
    }
}
