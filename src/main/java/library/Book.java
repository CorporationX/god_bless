package library;

import java.util.Map;
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

    public static void addBook(Map<Book,String> test, String s, String author, String title, int year) {
        test.put(new Book(title,author,year), s);
    }
    public static void removeBook(Map<Book,String> test, String title, String author, int year) {
        test.remove(new Book(title,author,year));
    }
    public static void searchBook(Map<Book,String> test, String title, String author, int year) {
        System.out.println(test.get(new Book(title,author,year)));
    }
    public static void outputBook(Map<Book,String> test) {
        for (Map.Entry<Book, String> pair : test.entrySet()) {
            System.out.println(pair.getValue() + " : " + pair.getKey().title + " - " + pair.getKey().author + " - " + pair.getKey().year);

        }
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
}
