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
    @DisplayName("Создание пользователя с невалидными данными")
    public void testCreateUserWithInvalidData() {
        assertAll(
                () -> {
                    Exception emptyNameException = assertThrows(IllegalArgumentException.class,
                            () -> new User("", 19, "Google", "London"));
                    assertEquals("Name cannot be empty", emptyNameException.getMessage());
                },
                () -> {
                    Exception invalidAgeException = assertThrows(IllegalArgumentException.class,
                            () -> new User("Alice", 15, "Google", "London"));
                    assertEquals("Age must be at least 18", invalidAgeException.getMessage());
                },
                () -> {
                    Exception invalidJobException = assertThrows(IllegalArgumentException.class,
                            () -> new User("Alice", 19, "Yandex", "London"));
                    assertEquals("Job is not valid", invalidJobException.getMessage());
                },
                () -> {
                    Exception invalidAddressException = assertThrows(IllegalArgumentException.class,
                            () -> new User("Alice", 21, "Google", "Saint Petersburg"));
                    assertEquals("Address is not valid", invalidAddressException.getMessage());
                }
        );
    }
}
