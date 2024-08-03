package faang.school.godbless.userregistration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    @DisplayName("Создание валидного пользователя")
    public void testCreateValidUser() {
        User user = new User("Alice", 19, "Google", "London");

        assertAll(
                () -> assertNotNull(user),
                () -> assertEquals("Alice", user.getName()),
                () -> assertEquals(19, user.getAge()),
                () -> assertEquals("Google", user.getJob()),
                () -> assertEquals("London", user.getAddress())
        );
    }

    @Test
    @DisplayName("Создание пользователя с пустым именем")
    public void testCreateUserWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("", 19, "Google", "London"));

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Создание пользователя с возрастом меньше 18 лет")
    public void testCreateUserWithInvalidAge() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Alice", 15, "Google", "London"));

        assertEquals("Age must be at least 18", exception.getMessage());
    }

    @Test
    @DisplayName("Создание пользователя с местом работы не из требуемого множества")
    public void testCreateUserWithInvalidJob() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Alice", 19, "Yandex", "London"));

        assertEquals("Job is not valid", exception.getMessage());
    }

    @Test
    @DisplayName("Создание пользователя с адресом не из требуемого множества")
    public void testCreateUserWithInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("Alice", 21, "Google", "Saint Petersburg"));

        assertEquals("Address is not valid", exception.getMessage());
    }
}
