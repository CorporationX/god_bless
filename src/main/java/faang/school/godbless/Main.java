package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> mapBook = new HashMap<>();
        //
        Book book1 = new Book("Маленький принц", "Экзюпери", 1965);
        mapBook.put(book1, "B");

        Book book2 = new Book("Атлант расправил плечи", "Айн Ренд", 1957);
        mapBook.put(book2, "A");

        Book book3 = new Book("Преступление и Наказание", "Достоевский", 1866);
        mapBook.put(book3, "C");

        Book book4 = new Book("Война и мир", "Толстой", 1863);
        mapBook.put(book4, "D");

        Book book5 = new Book("Раковые яйца", "Булгакова", 1924);
        mapBook.put(book5, "E");

        addBook(mapBook, new Book("1984", "Оруел", 1949), "C");

        findBook(mapBook, "Атлант расправил плечи", "Айн Ренд", 1957);

        removeBook(mapBook, "Преступление и Наказание", "Достоевский", 1866);

        displayBooks(mapBook);


    }

    private static void addBook(Map<Book, String> mapBook, Book book, String location) {
        //добавление
        mapBook.put(book, location);
        System.out.println("Book" + book.getTitle() + "added successfully:");
    }


    private static void removeBook(Map<Book, String> mapBook, String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        mapBook.remove(bookToRemove);
    }

    private static void findBook(Map<Book, String> mapBook, String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = mapBook.get(bookToFind);
        if (location != null) {
            System.out.println("Book found in " + location);
        } else {
            System.out.println("Book not found");
        }
    }

    private static void displayBooks(Map<Book, String> mapBook) {
        for (Map.Entry<Book, String> entry : mapBook.entrySet()) {
            System.out.println("Title: " + entry.getKey().getTitle() +
                    "Author: " + entry.getKey().getAuthor() +
                    "Year: " + entry.getKey().getYear() +
                    "Location: " + entry.getValue());
        }
    }

}
