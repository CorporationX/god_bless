package faang.school.godbless.userRegistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private User correctUser1;
    private User correctUser2;
    private User incorrectUser1;
    private User incorrectUser2;
    private User incorrectUser3;
    private User incorrectUser4;


    @Test
    public void testValidUser() {
        User user = new User("John Doe", 30, "London", "Google");
        assertEquals("John Doe", user.getName());
        assertEquals(30, user.getAge());
        assertEquals("London", user.getAddress());
        assertEquals("Google", user.getPlaceOfWork());
    }

    @Test
    public void testEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("", 25, "London", "Google");
        });
        assertEquals("name is empty", exception.getMessage());
    }

    @Test
    public void testInvalidAgeTooYoung() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Jane Doe", 17, "London", "Google");
        });
        assertEquals("age less then 18 or very much", exception.getMessage());
    }

    @Test
    public void testInvalidAgeTooOld() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Jane Doe", 126, "London", "Google");
        });
        assertEquals("age less then 18 or very much", exception.getMessage());
    }

    @Test
    public void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Jane Doe", 25, "InvalidAddress", "Google");
        });
        assertEquals("Choose correct address", exception.getMessage());
    }

    @Test
    public void testInvalidPlaceOfWork() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("Jane Doe", 25, "London", "InvalidJob");
        });
        assertEquals("Choose correct place of work", exception.getMessage());
    }

}
