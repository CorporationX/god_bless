package school.faang.bjs2_68727.vesteross_library;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Red hat", "public", 1900, "123");
        librarySystem.printAllBooks();
        librarySystem.addBook("Harry Potter", "Roaling", 2001, "125");
        librarySystem.addBook("Kolobok", "public", 1850, "121");
        String location = librarySystem.findBook("Harry Potter", "Roaling", 2001);
        if (location != null) {
            log.info("Book title: {}, location: {}", "Harry Potter", location);
        }
        location = librarySystem.findBook("Teremok", "public", 1852);
        if (location != null) {
            log.info("Book title: {}, location: {}", "Teremok", location);
        }
        librarySystem.printAllBooks();
        librarySystem.removeBook("Kolobok", "public", 1850);
        librarySystem.removeBook("Teremok", "public", 1852);
        librarySystem.printAllBooks();

    }


}
