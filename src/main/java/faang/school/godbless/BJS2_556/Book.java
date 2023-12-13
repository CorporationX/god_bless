package faang.school.godbless.BJS2_556;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    String title;
    String author;
    int year;
    public Book(String title, String author, int year){
        this.title=title;
        this.author=author;
        this.year=year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
    public String toString(){
        return getTitle()+", "+getAuthor()+", "+getYear();
    }

}
