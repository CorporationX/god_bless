package school.faang.bjs2_79708;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return String.format("%s by %s, %d", this.getTitle(), this.getAuthor(), this.getYear());
    }
}
