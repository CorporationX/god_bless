package test.school.faang.sprint_1.task_45264;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint_1.task_45264.LibrarySystem;

public class LibrarySystemTest {
    LibrarySystem librarySystem;

    @BeforeEach
    void setUp() {
        librarySystem = new LibrarySystem();
    }


    @Test
    void testAddBookAndFindBook() {
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "1");

        Assertions.assertEquals(
                librarySystem.findBook("To Kill a Mockingbird", "Harper Lee", 1960),
                "1"
        );
    }

    @Test
    void testRemoveBook() {
        librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "1");

        librarySystem.removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        Assertions.assertEquals(
                librarySystem.findBook("To Kill a Mockingbird", "Harper Lee", 1960),
                "notFound"
        );
    }
}
