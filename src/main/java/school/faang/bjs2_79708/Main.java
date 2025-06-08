package school.faang.bjs2_79708;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Shelf A1");
        library.addBook("1984", "George Orwell", 1949, "Shelf B2");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "Shelf C3");
        library.addBook("1984", "George Orwell", 1949, "Shelf B2");

        System.out.println("\nПоиск книги '1984':");
        log.info(library.findBook("1984", "George Orwell", 1949));

        System.out.println("\nПоиск несуществующей книги:");
        log.info(library.findBook("Dune", "Frank Herbert", 1965));

        System.out.println("\nУдаление книги 'The Hobbit':");
        library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);

        System.out.println("\nПоиск удалённой книги:");
        log.info(library.findBook("The Hobbit", "J.R.R. Tolkien", 1937));

        System.out.println("\nСписок всех книг:");
        library.printAllBooks();
    }
}
