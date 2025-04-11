package school.faang.bjs2_68886;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;

    private boolean compareAuthorWith(String str) {
        return Objects.equals(getAuthor(), str);
    }

    private boolean compareTitleWith(String str) {
        return Objects.equals(getTitle(), str);
    }

}
