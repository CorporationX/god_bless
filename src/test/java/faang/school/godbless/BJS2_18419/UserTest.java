package faang.school.godbless.BJS2_18419;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("Создание валидного пользователя")
    public void testCreateValidUser() {
        User user = new User("Alice", 19, "Google", "London");

        assertAll(
                () -> assertNotNull(user),
                () -> assertEquals("Alice", user.getName()),
                () -> assertEquals(19, user.getAge()),
                () -> assertEquals("Google", user.getWorkPlace()),
                () -> assertEquals("London", user.getAddress())
        );
    }

    @Test
    @DisplayName("Создание пользователя с пустым именем")
    public void testInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", 19, "Google", "London"));

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Создание пользователя с возрастом меньше 18 лет")
    public void testInvalidAge() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Alice", 15, "Google", "London"));

        assertEquals("Age must be at least 18", exception.getMessage());
    }

    @Test
    @DisplayName("Создание пользователя с местом работы не из требуемого набора")
    public void testInvalidJob() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Alice", 19, "Yandex", "London"));

        assertEquals("Work Place is not valid", exception.getMessage());
    }

    @Test
    @DisplayName("Создание пользователя с адресом не из требуемого набора")
    public void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Alice", 21, "Google", "Saint-Petersburg"));

        assertEquals("Address is not valid", exception.getMessage());
    }
}