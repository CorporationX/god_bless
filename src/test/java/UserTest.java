import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void creationIncorrectAgeUserTest() {

        try {
            User user = new User("BOB", 10, "Uber", "Amsterdam");
        } catch (IllegalArgumentException ilae) {
            assertEquals(ilae.getMessage(), "Age couldn't be less than 18");
        }
    }

    @Test
    void creationIncorrectNameUserTest() {

        try {
            User user = new User(null, 18, "Uber", "Amsterdam");
        } catch (IllegalArgumentException ilae) {
            assertEquals(ilae.getMessage(), "Name couldn't be empty");
        }
    }

    @Test
    void creationIncorrectJobUserTest() {

        try {
            User user = new User("BOB", 18, "Unknown", "Amsterdam");
        } catch (IllegalArgumentException ilae) {
            assertEquals(ilae.getMessage(), "Job should be from [Amazon, Uber, Google]");
        }
    }

    @Test
    void creationIncorrectAddressUserTest() {

        try {
            User user = new User("BOB", 18, "Amazon", "Russia");
        } catch (IllegalArgumentException ilae) {
            assertEquals(ilae.getMessage(), "Address should be from [New York, London, Amsterdam]");
        }
    }

    @Test
    void creationCorrectUserTest() {

        User user = new User("BOB", 18, "Amazon", "London");
        assertEquals(user, new User("BOB", 18, "Amazon", "London"));
    }
}
