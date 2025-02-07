package school.faang.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

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

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        String formattedString = String.format("Title - %s, author - %s, year - %d", title, author, year);
        return formattedString;
    }

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("New Harry Potter", "Amanzhol", 2025, "first place");
        librarySystem.findBook("New Harry Potter", "Amanzhol", 2025);
        librarySystem.findBook("Old Harry Potter", "Amanzhol", 2025);
        librarySystem.removeBook("New Harry Potter", "Amanzhol", 2025);
        librarySystem.findBook("New Harry Potter", "Amanzhol", 2025);
        librarySystem.addBook("New Harry Potter", "Amanzhol", 2025, "first place");
        librarySystem.addBook("The school", "Mikhail", 1980, "second place");
        librarySystem.addBook("The University", "Oleg", 2020, "first place");
        librarySystem.addBook("The University", "Oleg", 2020, "second place");
        librarySystem.printAllBooks();
    }
}
