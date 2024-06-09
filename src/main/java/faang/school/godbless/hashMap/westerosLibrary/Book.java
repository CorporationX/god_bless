package faang.school.godbless.hashMap.westerosLibrary;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new IllegalArgumentException("Title can`t be empty");
        }
        if (author == null || author.isEmpty() || author.isBlank()) {
            throw new IllegalArgumentException("Author can`t be empty");
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book " + title + " by " + author + " - " + year;
    }
}
