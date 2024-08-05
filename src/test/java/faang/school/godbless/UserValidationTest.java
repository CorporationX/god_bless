package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {
    @Test
    void userCreationSuccess(){
        User user = new User("Emily", 28, "Amazon", "London");
        assertNotNull(user);
    }
    @Test
    void userCreationFailedByName(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    User user = new User("", 28, "Google", "Amsterdam");
                });
    }
    @Test
    void userCreationFailedByAge(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    User user = new User("Stacy", 17, "Uber", "New York");
                });
    }
    @Test
    void userCreationFailedByWorkPlace(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    User user = new User("John", 18, "Meta", "London");
                });
    }
    @Test
    void userCreationFailedByAddress(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    User user = new User("John", 18, "Uber", "Los Angeles");
                });
    }
}