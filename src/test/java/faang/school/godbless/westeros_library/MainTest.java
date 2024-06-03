package faang.school.godbless.westeros_library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testLibrary() {
        Main main = new Main();
        main.burnBook("Lannister", "Mad King", 264);
        main.addBook(new Book("Snow", "Three-Eyed Raven", 304), "Row 2, shelf 2");
        System.out.println(main.askLibrarianWhereBook("Dragons", "Targaryen", 234));
        main.libraryInspection();
    }

}