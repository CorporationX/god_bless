package school.faang.BJS2_33136;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
