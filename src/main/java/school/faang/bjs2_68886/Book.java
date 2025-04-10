package school.faang.bjs2_68886;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book o = (Book) obj;

        return compareTitleWith(o.getTitle()) && compareAuthorWith(o.getAuthor()) && getYear() == o.getYear();
    }

    private boolean compareAuthorWith(String str) {
        return Objects.equals(getAuthor(), str);
    }

    private boolean compareTitleWith(String str) {
        return Objects.equals(getTitle(), str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getYear());
    }

}
