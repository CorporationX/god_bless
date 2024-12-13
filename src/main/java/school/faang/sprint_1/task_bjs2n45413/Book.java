package school.faang.sprint_1.task_bjs2n45413;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private static final int MAX_TITLE_LENGTH = 100;
    private static final int MAX_AUTHOR_LENGTH = 100;
    private static final int MAX_YEAR = 2050;
    private static final int MIN_YEAR = -5000;
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) throws InvalidInputException {
        if (paramsAreCorrect(title, author, year)) {
            this.title = title;
            this.author = author;
            this.year = year;
        } else {
            throw new InvalidInputException("invalid parameters of the book");
        }

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

    private boolean paramsAreCorrect(String title, String author, int year) {
        return (title != null
                && author != null
                && title.length() <= MAX_TITLE_LENGTH
                && author.length() <= MAX_AUTHOR_LENGTH
                && year >= MIN_YEAR
                && year <= MAX_YEAR
                );
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


