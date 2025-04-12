package school.faang.bjs2_68727.vesteross_library;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    private static final String BOOK_LOCATION_INFO = "Book title: {}, location: {}";

    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Red hat", "public", 1900, "123");
        librarySystem.addBook("Harry Potter", "Roaling", 2001, "125");
        librarySystem.addBook("Kolobok", "public", 1850, "121");

        try {
            String location = librarySystem.findBook("Harry Potter", "Roaling", 2001);
            log.info(BOOK_LOCATION_INFO, "Harry Potter", location);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
        try {
            String location = librarySystem.findBook("Teremok", "public", 1852);
            log.info(BOOK_LOCATION_INFO, "Teremok", location);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }

        librarySystem.printAllBooks();

        try {
            librarySystem.removeBook("Kolobok", "public", 1850);
            log.info("{} is removed", "Kolobok");
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
        try {
            librarySystem.removeBook("Teremok", "public", 1852);
            log.info("{} is removed", "Teremok");
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }

        librarySystem.printAllBooks();
    }
}
