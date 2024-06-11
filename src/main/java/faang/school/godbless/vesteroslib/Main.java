package faang.school.godbless.vesteroslib;

import faang.school.godbless.helpers.CustomException;

import java.util.*;

public class Main {
    private static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        try {
            addBook("Borodino", "Tolstoy", 1822, "g-1");
            addBook("Hamlet", "Shakespeare", 1555, "c-2");
            deleteBook("War and peace", "Tolstoy", 1822);
            getBookInfo("War and peace", "Tolstoy", 1822);
            getBookInfo("Hamlet", "Shakespeare", 1555);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(books.toString());
    }

    public static void addBook(String name, String author, Integer year, String position) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Book name is empty");
        }
        if (author.isEmpty()) {
            throw new Exception("Author name is empty");
        }
        if (position.isEmpty()) {
            throw new Exception("Position name is empty");
        }
        Book bookToAdd = new Book(name, author, year);
        books.put(bookToAdd, position);
    }

    public static void getBookInfo(String name, String author, Integer year) throws Exception {
        List<Book> booksList = new ArrayList<>(books.keySet());
        Book params = new Book(name, author, year);
        System.out.println("params are " + params.toString());
        List<Book> bookToFind = booksList.stream().filter(book -> book.equals(params)).toList();
        if (bookToFind.isEmpty()) {
            throw new Exception("Book is not found");
        }
        System.out.println(bookToFind.get(0).toString()+" "+books.get(bookToFind.get(0)));
    }

    public static void deleteBook(String name, String author, Integer year) {
        List<Book> booksList = new ArrayList<>(books.keySet());
        Book params = new Book(name, author, year);
        Book bookToDelete = booksList.stream().filter(book -> book.equals(params)).toList().get(0);
        books.remove(bookToDelete);
    }
}
