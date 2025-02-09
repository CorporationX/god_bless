package school.faang.BJS2_57129;

import java.util.Objects;

public class Book {

    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        validate(title, author, year);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    private void validate(String title, String author, int year) {
        if (Objects.isNull(title) || title.isBlank()) {
            throw new IllegalArgumentException("Наименование книги не должно быть пустым");
        }
        if (Objects.isNull(author) || author.isBlank()) {
            throw new IllegalArgumentException("Необходимо указать автора книги");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Год издания не должен быть отрицательным!");
        }
    }

    @Override
    public String toString() {
        return "Книга:{" +
                "Название = '" + title + '\'' +
                ", автор = '" + author + '\'' +
                ", год издания = " + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

}
