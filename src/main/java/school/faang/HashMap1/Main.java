package school.faang.HashMap1;

import java.util.HashMap;
import java.util.Map;

import static school.faang.HashMap1.Book.searchBook;

public class Main {
    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();
        library.put(new Book("book1", "author1", 1975), "1");
        library.put(new Book("book2", "author2", 2005), "2");
        library.put(new Book("book3", "author3", 2024), "3");

        Book.addBook(new Book("book4", "author4", 2000), "4", library);
        Book.printBooksInfo(library);
        System.out.println("\nПоиск book4:");
        Book.printBook(searchBook("book4", "author4", 2000, library), library);
        Book.deleteBook("book4", "author4", 2000, library);
        System.out.println("\nПоиск удаленной book4:");
        Book.printBook(searchBook("book4", "author4", 2000, library), library);
        Book.printBooksInfo(library);

    }
}
