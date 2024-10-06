package libraryWesteros;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<Book, String> books = new HashMap<>(){{
        put(new Book("Война и мир I","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир II","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир III","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир IV","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир V","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир VI","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир VII","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
        put(new Book("Война и мир VIII","Толстой Л.Н.", 2000 ),"5 стелаж 3 полка");
    }};

    public static void addBook(Book book, String bookLocation) {
        books.put(book, bookLocation);
    }

    public static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        return books.get(new Book(title, author, year));
    }

    public static void printBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().toString() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        deleteBook("Война и мир VI","Толстой Л.Н.",2000);
        printBooks();
        System.out.println();
        addBook(new Book("Война и мир VI","Толстой Л.Н.",2000),"5 стелаж 3 полка");
        printBooks();
        System.out.println();
        System.out.println(findBook("Война и мир I","Толстой Л.Н.",2000));

    }
}
