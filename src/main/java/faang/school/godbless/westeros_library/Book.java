package faang.school.godbless.westeros_library;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Book {
    String title;
    String author;
    int year;

    @Override
    public int hashCode() {
        return year+title.hashCode()+author.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book other = (Book) obj;
            return year == other.year && title.equals(other.title) && author.equals(other.author);
        }
        return false;
    }
}
