package BJS2_19344;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Book {
    private String title;
    private String author;
    private int yearOfPublish;

    public Book(String title, String author, int yearOfPublish) {
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublish == book.yearOfPublish && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfPublish);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }
}
