package school.faang.task_45327;

import lombok.Data;

import java.util.Objects;

@Data
public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Book otherBook = (Book) o;
        return title.equals(otherBook.getTitle())
                && author.equals(otherBook.getAuthor())
                && year == otherBook.getYear();
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", year=" + year + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
