package faang.school.godbless;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setYear(year);
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) this.title = title;
        else throw new IllegalArgumentException(title + " this is empty title");
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) this.author = author;
        else throw new IllegalArgumentException(author + " this is empty author's name");
    }

    public void setYear(int year) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        else {
            Book book = (Book) o;
            return this.title == book.title && this.author == book.author && this.year == book.year;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.author, this.year);
    }

    @Override
    public String toString() {
        return "|" + this.title + "| |" + this.author + "|  " + this.year;
    }
}