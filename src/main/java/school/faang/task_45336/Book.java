package school.faang.task_45336;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Некорректное название книги!");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Некорректное автор книги!");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Книга {"
            + "название='" + title + '\''
            + ", автор='" + author + '\''
            + ", год=" + year
            + '}';
    }
}
