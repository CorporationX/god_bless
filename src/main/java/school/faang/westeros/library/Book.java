package school.faang.westeros.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    private String title, author;
    private int year;

    public String getInfo() {
        return String.format("\"%s\", %s, %d", this.title, this.author, this.year);
    }
}
