package school.faang.bjs2_86197;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "Книга {" +
                "заглавие='" + title + '\'' +
                ", автор='" + author + '\'' +
                ", год=" + year +
                '}';
    }
}
