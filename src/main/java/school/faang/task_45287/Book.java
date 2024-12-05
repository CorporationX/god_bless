package school.faang.task_45287;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String _title, String _author, int _year) {
        this.title = _title;
        this.author = _author;
        this.year = _year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book CurBook = (Book) obj;
        return title == CurBook.title && author == CurBook.author && year == CurBook.year;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int i = prime * Objects.hash(title, author, year);
        return i;
    }

    @Override
    public String toString() {
        return "Book{"
                + "title='" + title + '\''
                + ", author='" + author + '\''
                + ", year=" + year
                + '}';
    }
}
