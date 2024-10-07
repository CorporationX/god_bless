package school.faang.vesteroslibrary;

import lombok.Getter;

@Getter
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
        return "Название = " + title + ", Автор = " + author + ", Год = " + year + " ->";
    }

    @Override
    public int hashCode() {
        return 31 * title.hashCode() + author.hashCode() + year;
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
        return year == book.year && title.equals(book.title) && author.equals(book.author);
    }

}
