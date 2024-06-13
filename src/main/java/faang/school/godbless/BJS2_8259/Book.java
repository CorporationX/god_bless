package faang.school.godbless.BJS2_8259;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title.isBlank()) {
            System.out.println("Некорректное название книги");
            return;
        }
        if (author.isBlank()) {
            System.out.println("Некорректный автор");
            return;
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
