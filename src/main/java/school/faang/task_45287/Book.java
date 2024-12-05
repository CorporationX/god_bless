package school.faang.task_45287;

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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book curBook = (Book) obj;
        return title == curBook.title && author == curBook.author && year == curBook.year;
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
