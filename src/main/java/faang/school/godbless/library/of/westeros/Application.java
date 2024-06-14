package faang.school.godbless.library.of.westeros;

import faang.school.godbless.library.of.westeros.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private static Map<Book, String> books = new HashMap<>();

    public static void addNewBook(Book book, String place) {
        books.put(book, place);
    }

    public static void deleteBookByTitle(String title) {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            if(entry.getKey().getTitle().equals(title)) {
                Book book = entry.getKey();
                books.remove(book);
                break;
            }
        }
    }

    public static void deleteBookByAuthor(String author) {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            if(entry.getKey().getAuthor().equals(author)) {
                Book book = entry.getKey();
                books.remove(book);
                break;
            }
        }
    }

    public static void deleteBookByYear(LocalDate year) {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            if(entry.getKey().getYear().equals(year)) {
                Book book = entry.getKey();
                books.remove(book);
                break;
            }
        }
    }

    public static void findBookByAuthor(String author) {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            if(entry.getKey().getAuthor().equals(author)) {
                Book book = entry.getKey();
                System.out.println(books.get(book));
                break;
            }
        }
    }

    public static void findBookByYear(LocalDate year) {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            if(entry.getKey().getYear().equals(year)) {
                Book book = entry.getKey();
                System.out.println(books.get(book));
                break;
            }
        }
    }

    public static void findBookByTitle(String title) {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            if(entry.getKey().getTitle().equals(title)) {
                Book book = entry.getKey();
                System.out.println(books.get(book));
                break;
            }
        }
    }

    public static void printBooks() {
        for(Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().toString() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        addNewBook(new Book("title1", "author1", LocalDate.of(2006, 7, 15)), "1");
        addNewBook(new Book("title2", "author2", LocalDate.of(2005, 7, 15)), "2");
        addNewBook(new Book("title3", "author3", LocalDate.of(2004, 7, 15)), "3");

        printBooks();
        deleteBookByYear(LocalDate.of(2005, 7, 15));
        printBooks();

        /*
        Я проверил все методы, что написал - они работаю.
        Просто я почему-то решил проверять каждый метод
        когда писал его по факту - потом стирать код - снова писать для след. метода.
         */
    }
}
