package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        books.put(new Book("Martin Eden", "Jack London", 1909), "B45R33");
        books.put(new Book("Clean Code", "Robert Martin", 2008), "C13K14");
        books.put(new Book("Grokking Algorithms", "Aditya Bhargava", 2015), "D12M43");
        books.put(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997), "F09X44");
        books.put(new Book("Arch of Triumph", "Erich Maria Remarque", 1945), "T23M55");

        addBook(books, new Book("Thinking in Java", "Eckel Bruce", 1998), "S00V83");
        deleteBookByTitle(books, "Martin eden");
        findBookPlaceByAuthor(books, "Eckel Bruce");
        findBookPlaceByTitle(books, "Clean Code");
        findBookPlaceByYear(books, 1998);
        printAllBooks(books);
    }

    public static void addBook(Map<Book, String> books, Book book, String place) {
        books.put(book, place);
    }

    public static void deleteBookByTitle(Map<Book, String> books, String title) {
        for (Book book : books.keySet()) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
            }
        }
    }

    public static void deleteBookByAuthor(Map<Book, String> books, String author) {
        for (Book book : books.keySet()) {
            if (book.getAuthor().equals(author)) {
                books.remove(book);
            }
        }
    }

    public static void deleteBookByYear(Map<Book, String> books, int year) {
        for (Book book : books.keySet()) {
            if (book.getYear() == year) {
                books.remove(book);
            }
        }
    }

    public static void findBookPlaceByTitle(Map<Book, String> books, String title) {
        for (Book book : books.keySet()) {
            if (book.getTitle().equals(title)) {
                System.out.printf("%s: %s\n", title, books.get(book));
            }
        }
    }

    public static void findBookPlaceByAuthor(Map<Book, String> books, String author) {
        for (Book book : books.keySet()) {
            if (book.getAuthor().equals(author)) {
                System.out.printf("%s: %s\n", author, books.get(book));
            }
        }
    }

    public static void findBookPlaceByYear(Map<Book, String> books, int year) {
        for (Book book : books.keySet()) {
            if (book.getYear() == year) {
                System.out.printf("%d: %s\n", year, books.get(book));
            }
        }
    }

    public static void printAllBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
