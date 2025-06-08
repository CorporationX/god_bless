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

        log.info("Поиск книги: 1984");
        library.findBook("1984", "George Orwell", 1949);

        log.info("Поиск несуществующей книги:");
        library.findBook("Dune", "Frank Herbert", 1965);

        log.info("Удаление книги: The Hobbit");
        library.removeBook("The Hobbit", "J.R.R. Tolkien", 1937);

        log.info("Поиск удалённой книги:");
        library.findBook("The Hobbit", "J.R.R. Tolkien", 1937);

        log.info("Список всех книг:");
        library.printAllBooks();
    }
}
