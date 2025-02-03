package school.faang;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;
    private static final int CURRENT_YEAR = 2025;

    public void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title can't be null or blank");
        }
    }

    public void validateAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can't be null");
        }
    }

    public void validateYear(int year) {
        if (year < 0 || year > CURRENT_YEAR) {
            throw new IllegalArgumentException("Year can't be negative or bigger than current");
        }
    }

    public Book(String title, String author, int year) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);

        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(year, book.year) && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
