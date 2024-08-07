package faang.school.godbless.BJS2_18413;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructor() {

        assertThrows(IllegalArgumentException.class,() -> new User("", 20, "Uber", "Amsterdam"));
        assertThrows(IllegalArgumentException.class,() -> new User(null, 20, "Uber", "Amsterdam"));
        assertThrows(IllegalArgumentException.class,() -> new User("Ivan", 15, "Uber", "Amsterdam"));
        assertThrows(IllegalArgumentException.class,() -> new User("Ivan", 19, "Yandex", "Amsterdam"));
        assertThrows(IllegalArgumentException.class,() -> new User("Ivan", 19, "Uber", "Moscow"));
        assertDoesNotThrow(() -> new User("Ivan", 19, "Uber", "London"));
    }

}