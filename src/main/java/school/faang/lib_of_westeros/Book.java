package school.faang.lib_of_westeros;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object key) {
        if (this == key) return true;
        if (key == null
                || getClass() != key.getClass()) {return false;}
        Book book = (Book) key;
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
        return title + " by " + author + " (" + year + ")";
    }
}