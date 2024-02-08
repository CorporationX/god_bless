package faang.school.godbless.library_westeros;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null || o.getClass()!=getClass()) return false;
        Book b = (Book) o;
        return title.equals(b.title) && author.equals( b.author ) && year==b.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash( title, author, year );
    }
}
