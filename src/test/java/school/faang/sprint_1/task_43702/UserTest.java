package school.faang.sprint_1.task_43702;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void testRightUserCreate() {
        User expectedUser = new User("Petya", 19, "Google", "New York");

        User actualUser = new User("Petya", 19, "Google", "New York");

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testUserCreateWithBlankName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new User("", 19, "Google", "New York")
        );
    }

    @Test
    void testUserCreateWithAgeLess18() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new User("Gosha", 13, "Google", "New York")
        );
    }

    @Test
    void testUserCreateWithNotValidJob() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new User("Gosha", 19, "Factory", "New York")
        );
    }

    @Test
    void testUserCreateWithNotValidAddress() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new User("Gosha", 19, "Google", "Moscow")
        );
    }
}
