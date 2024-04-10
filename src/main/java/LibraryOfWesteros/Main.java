package LibraryOfWesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Book, String> books = new HashMap<Book, String>();

    public static void main(String[] args) {
        Book clockworkOrange = new Book("Заводной апельсин", "Энтони Бёрджес", 2011);
        Book everything = new Book("Весь этот мир", "Никола Юн", 2014);
        Book theCatcherInTheRye = new Book("Над пропастью во ржи", "Дж. Д. Сэлинджер", 1951);
        Book redPill = new Book("Красная таблетка", "Андрей Курпатов", 2020);

        addBook(clockworkOrange, "123");
        addBook(everything, "456");
        addBook(theCatcherInTheRye, "789");
        addBook(redPill, "самая верхняя");

        System.out.println(getShelf("Весь этот мир", "Никола Юн", 2014));

        deleteBook("Весь этот мир", "Никола Юн", 2014);

        showBooks();
    }

    public static void addBook(Book book, String shelf) {
        books.put(book, shelf);
    }

    public static void deleteBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public static String getShelf(String title, String author, int year) {
        Book book = new Book(title, author, year);

        return books.get(book);
    }

    public static void showBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            Book book = entry.getKey();
            System.out.println("На полке " + entry.getValue() + " находится книга \"" + book.getTitle() + "\" (" + book.getAuthor() + ", " + book.getYear() + ")");
        }
    }

}
