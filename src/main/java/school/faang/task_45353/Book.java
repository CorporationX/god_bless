package school.faang.task_45353;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
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
        return Objects.equals(title, book.title) && Objects.equals(author, book.author)
                && Objects.equals(year, book.year);
    }


    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book{"
                + "title='" + title + '\''
                + ", author='" + author + '\''
                + ", year=" + year
                + '}';
    }
}
