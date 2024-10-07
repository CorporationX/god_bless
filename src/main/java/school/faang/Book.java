package school.faang;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Необходимо ввести название книги");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать автора книги");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Год выпуска книги не может быть отрицательным");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
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
        return year == book.year &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Книга: " + title + ", автор: " + author + ", год: " + year;
    }
}
