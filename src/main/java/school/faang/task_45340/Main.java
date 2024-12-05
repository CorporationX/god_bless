package school.faang.task_45340;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> books = new HashMap<>();

        Book book1 = new Book("title1", "author1", 1999);
        Book book2 = new Book("title2", "author2", 2000);

        books.put(book1, "Shelf #1");
        books.put(book2, "Shelf #2");

        System.out.println(books);

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("title3", "author3", 2001, "Shelf #3");
        librarySystem.addBook("title4", "author4", 2002, "Shelf #4");

        System.out.println("Все книги в библиотеке: ");
        librarySystem.printAllBooks();

        librarySystem.removeBook("title3", "author3", 2001);
        System.out.println("Книги после удаления: ");
        librarySystem.printAllBooks();

        System.out.println("Поиск несуществующей книги");
        System.out.println(librarySystem.findBook("title5", "author5", 2003));

    }
}
