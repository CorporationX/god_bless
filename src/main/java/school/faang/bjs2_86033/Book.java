package school.faang.bjs2_86033;

import java.util.Objects;

public record Book(String title, String author, int year) {
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object e) {
        if (this == e) {
            return true;
        }
        if (e == null || this.getClass() != e.getClass()) {
            return false;
        }

        Book newBook = (Book) e;

        return  author.equals(newBook.author)
                && title.equals(newBook.title)
                && year == newBook.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return title + " -- " + author + " -- " + year;
    }
}