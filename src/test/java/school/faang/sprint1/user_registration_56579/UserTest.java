package school.faang.sprint1.user_registration_56579;

import org.junit.jupiter.api.Test;
import school.faang.sprint1.user_registration_56579.User;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void rightParams() {
        assertDoesNotThrow(() -> new User("John", 20, "Uber", "London"));
    }

    @Test
    public void emptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("", 20, "Uber", "London"));
    }


    @Test
    public void wrongAge() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("John", 17, "Uber", "London"));
    }

    @Test
    public void wrongJob() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("John", 20, "Sber", "London"));
    }

    @Test
    public void emptyJob() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("John", 20, "", "London"));
    }


    @Test
    public void wrongAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("John", 20, "Uber", "Moscow"));
    }

    @Test
    public void emptyAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("John", 20, "Uber", ""));
    }

}
