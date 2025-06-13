package school.faang.BJS2_79727;

import school.faang.BJS2_79727.model.Book;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello BJS2-79727!");
        var librarySystem = new LibrarySystem();
        var martinEden = new Book("Martin Eden", "Jack London", Year.of(1909));
        var harryPotter = new Book("Harry Potter", "J.K. Rowling", Year.of(1997));
        librarySystem.addBook(
                harryPotter.getTitle(),
                harryPotter.getAuthor(),
                harryPotter.getYear().getValue(),
                "3H157");
        librarySystem.printAllBooks();
        var isRemoved = librarySystem.removeBook(
                harryPotter.getTitle(),
                harryPotter.getAuthor(),
                harryPotter.getYear().getValue());
        System.out.printf("Is removed %b%n \n", isRemoved);
        librarySystem.printAllBooks();
        librarySystem.addBook(
                martinEden.getTitle(),
                martinEden.getAuthor(),
                martinEden.getYear().getValue(),
                "1M122");
        librarySystem.printAllBooks();
        var foundBook = librarySystem.findBook(
                martinEden.getTitle(),
                martinEden.getAuthor(),
                martinEden.getYear().getValue());
        System.out.println(foundBook);
        var notFoundBook = librarySystem.findBook(
                harryPotter.getAuthor(),
                harryPotter.getAuthor(),
                harryPotter.getYear().getValue());
        System.out.println(notFoundBook);
    }
}
