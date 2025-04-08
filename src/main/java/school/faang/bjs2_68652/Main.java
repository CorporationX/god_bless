package school.faang.bjs2_68652;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("book1", "author1", 1999);
        Book book2 = new Book("book2", "author2", 2000);
        Book book3 = new Book("book3", "author3", 2000);
        Book book4 = new Book("book4", "author4", 2010);
        Book book5 = new Book("book5", "author5", 2010);
        Book book6 = new Book("book6", "author6", 2010);
        Map<Book, String> catalogue = new HashMap<>();
        catalogue.put(book1, "1");
        catalogue.put(book2, "2");
        catalogue.put(book3, "2");
        catalogue.put(book4, "2");
        catalogue.put(book5, "3");
        catalogue.put(book6, "3");
        LibrarySystem library = new LibrarySystem(catalogue);
        library.printAllBooks();

        library.addBook("book7", "author7", 2015, "2");
        log.info("Список книг после добавления book7");
        library.printAllBooks();

        library.removeBook("book3", "author3", 2000);
        log.info("Список книг после удаления book3");
        library.printAllBooks();

        log.info("Книга book1 находится в: {}",
                library.findBook("book1", "author1", 1999));

        library.removeBook("book8", "author3", 2000);
    }
}
