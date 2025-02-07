package school.faang.vesteros_library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final Map<Book, String> bookBase;

    public LibrarySystem() {
        bookBase = new HashMap<Book, String>();
    }

    void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookBase.put(book, location);
    }

    void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        bookBase.remove(book);
    }

    String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookBase.get(book);
        if (location == null) {
            System.out.println("This book have not found");
        }
        return  location;
    }

    void printAllBooks() {
        int[] i = {1};
        bookBase.forEach((k, v) -> {
            System.out.println(i[0] + ". Book: " + k + "\n" + "Location: " + v);
            i[0]++;
        });
    }

    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Мастер и маргарита", "Булгаков", 1788, "Верхний стеллаж, полка №1");
        librarySystem.addBook("Мцыри", "Лермонтов", 1850, "Нижний стеллаж, полка №2");
        librarySystem.addBook("Бродяги севера", "Джейс", 1911, "Нижний стеллаж, полка №3");
        librarySystem.addBook("Морфий", "Булгаков", 1870, "Нижний стеллаж, полка №4");
        librarySystem.addBook("Истории успеха", "Генри Форд", 1900, "Средний стеллаж, полка №2");

        librarySystem.printAllBooks();
        librarySystem.removeBook("Мастер и маргарита", "Булгаков", 1788);
        System.out.println("****************************************");
        librarySystem.printAllBooks();
        System.out.println(librarySystem.findBook("Бродяги севера", "Джейс", 1911));

    }
}
