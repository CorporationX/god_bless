package school.BJS2_29018;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Book, String> mappa = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Война и мир", "Толстой", 1873), "Полка номер 10");
        addBook(new Book("Преступление и наказание", "Достоевский", 1866), "Полка номер 6");
        addBook(new Book("Самый успешный блогер на деревне", "Милохин", 2024), "Полка номер 5");
        System.out.println(getLine("Милохин", "Самый успешный блогер на деревне", 2024));
        System.out.println("---------------------------------------------");
        printLibrary();
        System.out.println("---------------------------------------------");
        removeBook("Милохин", "Самый успешный блогер на деревне", 2024);
        printLibrary();
    }

    //добавление новой книги и её местонахождения в библиотеке
    private static void addBook(Book book, String line) {
        mappa.put(book, line);
    }

    //удаление книги по её названию, автору и году издания
    private static void removeBook(String author, String title, int year) {
        Book book = new Book(title, author, year);
        mappa.remove(book);
    }

    //поиск книги и вывода информации о её местонахождении в библиотеке
    private static String getLine(String author, String title, int year) {
        Book book = new Book(title, author, year);
        return mappa.get(book);
    }

    //вывод списка всех книг и их местонахождения в библиотеке.
    private static void printLibrary() {
        for (Map.Entry<Book, String> entry : mappa.entrySet()) {
            String bookAuthor = entry.getKey().getAuthor();
            String bookTitle = entry.getKey().getTitle();
            int bookYear = entry.getKey().getYear();
            String line = entry.getValue();
            System.out.printf("Книга с названием: %s, автором: %s и годом выпуска: %d находится на %s", bookTitle, bookAuthor, bookYear, line);
            System.out.println();
        }
    }

    //проверка является ли книга нужной
    private static boolean checkBook(String author, String title, int year, Book book) {
        String bookAuthor = book.getAuthor();
        String bookTitle = book.getTitle();
        int bookYear = book.getYear();
        return author.equals(bookAuthor) && title.equals(bookTitle) && year == bookYear;
    }

}
