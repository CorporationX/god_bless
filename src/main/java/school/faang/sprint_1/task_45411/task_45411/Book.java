package school.faang.sprint_1.task_45411.task_45411;

import lombok.ToString;

import java.time.Year;
import java.util.Objects;

@ToString
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (validateBookInfo(title, author, year)) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
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

    protected boolean validateBookInfo(String title, String author, int year) {
        try {
            if (title.isBlank() || author.isBlank() || (year <= 0 || year > Year.now().getValue())) {
                throw new IllegalArgumentException("Enter valid book information!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Validation is failed: " + e.getMessage());
        }
        return true;
    }
}
