package libraryOfWesteros;

import lombok.Getter;
//import lombok.ToString;
import java.util.Objects;

@Getter
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        //нужна ли эта обработка?
        //и нужно ли в классе MainLibrary обрабатывать эти исключения с помощью Try catch
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Нет названия");
        } else if (author.isEmpty()) {
            throw new IllegalArgumentException("Нет автора");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return this.year == book.year && Objects.equals(this.author, book.author) && Objects.equals(this.title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
