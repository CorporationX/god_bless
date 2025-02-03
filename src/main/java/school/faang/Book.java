package school.faang;


import lombok.ToString;

import java.time.Year;

@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;


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
        if (year > Year.now().getValue()) {
            throw new IllegalArgumentException("Year can't be less than 2025");
        }
    }

    public Book(String title, String author, int year) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);

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
        return year == book.year &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, author, year);
    }
}