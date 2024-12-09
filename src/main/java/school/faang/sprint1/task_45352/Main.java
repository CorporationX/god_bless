package school.faang.sprint1.task_45352;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Book, String> bookLocation = new HashMap<>();
        bookLocation.put(new Book("The Idiot", "Fyodor Dostoevsky", 1869), "Shelf n.2");
        bookLocation.put(new Book("Dead Souls", "Nikolai Gogol", 1842), "Shelf n.2");
        bookLocation.put(new Book("Anna Karenina", "Leo Tolstoy", 1873), "Shelf n.1");

        LibrarySystem library = new LibrarySystem(bookLocation);
        library.printAllBooks();

        library.removeBook("The Idiot", "Fyodor Dostoevsky", 1869);
        library.printAllBooks();

        Book karamazovBook = library.addBook("The Brothers Karamazov", "Fyodor Dostoevsky", 1880, "Shelf n.2");
        library.findBook(karamazovBook.getTitle(), karamazovBook.getAuthor(), karamazovBook.getYear());
    }
}
