package LibraryOfWesteros;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal;

        if (this == obj) {
            equal = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            equal = false;
        } else {
            Book book = (Book) obj;
            equal = year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
        }

        return equal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
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

}
