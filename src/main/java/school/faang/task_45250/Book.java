package school.faang.task_45250;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private final String title;
    private final String author;
    private final Integer year;

    public Book(String title, String author, Integer year) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title не может быть пустым");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("author не может быть пустым");
        }
        if (year == null) {
            throw new IllegalArgumentException("year не может быть пустым");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, author, year);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
