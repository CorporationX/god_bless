package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
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

    public static void addNewBook(Map<Book, String> books, String title, String author, int year, String place) {
        books.put(new Book(title, author, year), place);
        System.out.println("The book has been added to place " + place);
    }

    public static void deleteBookByTitle(Map<Book, String> books, String title) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getTitle().equals(title)) {
                books.remove(entry.getKey());
                System.out.println("The book was successfully deleted");
            }
        }
    }

    public static void deleteBookByAuthor(Map<Book, String> books, String author) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                books.remove(entry.getKey());
                System.out.println("The book was successfully deleted");
            }
        }
    }

    public static void deleteBookByYear(Map<Book, String> books, int year) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getYear() == year) {
                books.remove(entry.getKey());
                System.out.println("The book was successfully deleted");
            }
        }
    }

    public static void printAllBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                    " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
        }
    }

    public static void findBookByTitle(Map<Book, String> books, String title) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getTitle().equals(title)) {
                System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                        " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
            }
        }
    }

    public static void findBookByAuthor(Map<Book, String> books, String author) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                        " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
            }
        }
    }

    public static void findBookByYear(Map<Book, String> books, int year) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getYear() == year) {
                System.out.println("Title: " + entry.getKey().getTitle() + " | Author: " + entry.getKey().getAuthor() +
                        " | Year: " + entry.getKey().getYear() + " | Place: " + entry.getValue());
            }
        }
    }

}
