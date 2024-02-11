package src.main.java.faang.school.godbless;

import java.util.Map;
import java.util.Objects;

import static src.main.java.faang.school.godbless.Main.map;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }


    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public static void addNewBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        int mesto = search(map);
        map.put(newBook, "#" + mesto);
    }

    private static int search(Map<Book, String> map) {
        int mesto = 1;
        while (map.containsValue("#" + mesto)) {
            mesto++;
        }
        return mesto;
    }

    public static void deleteBook(String title, String author, int year) {
        map.remove(new Book(title, author, year));

    }

    public static void SearchAndPrintBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
                System.out.println(book);
            }
        }
    }
}


