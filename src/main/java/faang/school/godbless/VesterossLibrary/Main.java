package faang.school.godbless.VesterossLibrary;


import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Book, String> LIBRARY = new HashMap<Book, String>();

    public static void main(String[] args) {
        LIBRARY.put(new Book("Metro 2033", "Glukhovsky", 2015), "наверху справа");
        LIBRARY.put(new Book("Басни Крылова", "Крылов", 2000), "наверху снизу");
        printAllBooks();
        System.out.println();
        addBook(new Book("Основы Java", "Николай Прохорёнок", 2020), "снизу сверху");
        printAllBooks();
        System.out.println();
        removeBook("Басни Крылова", "Крылов", 2000);
        printAllBooks();
        System.out.println(bookInfo("Основы Java", "Николай Прохорёнок", 2020));

    }

    private static void addBook(Book book, String location) {
        LIBRARY.put(book, location);
    }
    private static void removeBook(String bookName, String author, int year) {
        LIBRARY.remove(new Book(bookName, author, year));
    }
    private static String bookInfo(String bookName, String author, int year) {
        return LIBRARY.get(new Book(bookName, author, year));
    }
    private static void printAllBooks()
    {
        LIBRARY.forEach( (book, location) -> {
            System.out.printf("%s %s %d: %s\n", book.getTitle(), book.getAuthor(), book.getYear(), location);
        });
    }
}
