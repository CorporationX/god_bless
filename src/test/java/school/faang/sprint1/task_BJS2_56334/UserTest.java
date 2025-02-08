package school.faang.sprint1.task_BJS2_56334;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест класса User")
class UserTest {
    private User user;

    @Test
    public void constructor_rightParams() {
        assertDoesNotThrow(() -> new User("Vasya", 18, "Uber", "London"));
    }

    @Test
    public void constructor_emptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("", 38, "Amazon", "New York"));
    }

    @Test
    public void constructor_nullName() {
        assertThrows(IllegalArgumentException.class,
                () -> new User(null, 38, "Amazon", "New York"));
    }

    @Test
    public void constructor_wrongAge() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 17, "Amazon", "New York"));
    }

    @Test
    public void constructor_wrongJob() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 38, "Zavod", "New York"));
    }

    @Test
    public void constructor_emptyJob() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 38, "", "New York"));
    }

    @Test
    public void constructor_nullJob() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 38, null, "New York"));
    }

    @Test
    public void constructor_wrongAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 38, "Amazon", "Voronezh"));
    }

    @Test
    public void constructor_emptyAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 38, "Amazon", ""));
    }

    @Test
    public void constructor_nullAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("Some", 38, "Amazon", null));
    }
}