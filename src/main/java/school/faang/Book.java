package school.faang;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String author, int year, String title) {
        this.author = author;
        this.year = year;
        this.title = title;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode(){
        return Objects.hash(author, title, year);
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
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }
}
