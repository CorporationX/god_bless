package school.faang.task_57280;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }
}
