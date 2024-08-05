package faang.school.godbless.bjs2_19332;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Builder
@ToString
public class Book {
    private String title;
    private String author;
    private short year;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Book other = (Book) o;
        return Objects.equals(this.title, other.getTitle())
                && Objects.equals(this.author, other.getAuthor())
                && this.year == other.getYear();
    }

    @Override
    public int hashCode() {
        String toHash = "" + title + author + year;
        return toHash.hashCode();
    }
}
