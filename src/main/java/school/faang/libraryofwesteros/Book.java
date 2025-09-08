package school.faang.libraryofwesteros;

import java.util.Objects;

public class Book {
    private String tittle;
    private String author;
    private int year;

    public Book(String tittle, String author, int year) {
        this.tittle = tittle;
        this.author = author;
        this.year = year;
    }

    public String getTittle() {
        return tittle;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year
                && Objects.equals(tittle, book.tittle)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, author, year);
    }
}