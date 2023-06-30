package faang.school.godbless.Sprint_2.reg;

import faang.school.godbless.Sprint_2.Task_1_2.reg.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    @Test
    void constructorTestPos() {
        User user = new User("Ivan", 18, "Google", "London");

        assertEquals("Ivan", user.getName());
        assertEquals(18, user.getAge());
        assertEquals("Google", user.getPlaceOfWork());
        assertEquals("London", user.getAddress());
    }

    @Test
    void constructorTestNeg() {
        IllegalArgumentException nameException = assertThrows(IllegalArgumentException.class, () -> new User(" ", 18, "Google", "London"));
        IllegalArgumentException ageException = assertThrows(IllegalArgumentException.class, () -> new User("Ivan", 10, "Google", "London"));
        IllegalArgumentException workException = assertThrows(IllegalArgumentException.class, () -> new User("Ivan", 18, "Yandex", "London"));
        IllegalArgumentException addressException = assertThrows(IllegalArgumentException.class, () -> new User("Ivan", 18, "Google", "Roetov"));

        assertEquals("Name is empty", nameException.getMessage());
        assertEquals("Too young", ageException.getMessage());
        assertEquals("Work exception", workException.getMessage());
        assertEquals("Address exception", addressException.getMessage());
    }
}