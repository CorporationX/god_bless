package faang.school.godbless.BJS2_18407;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void testUserConstructor_validArguments() {
        String name = "Mikhail",
                placeWork = "Google",
                address = "London";
        int age = 18;

        User result = new User(name, age, placeWork, address);

        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(placeWork, result.getPlaceWork());
        assertEquals(address, result.getAddress());
    }

    @Test
    void testUserConstructor_EmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 25, "Google", "London"));
    }

    @Test
    void testUserConstructor_AgeLessEighteen() {
        assertThrows(IllegalArgumentException.class, () -> new User("Mikhail", 0, "Google", "London"));
    }

    @Test
    void testUserConstructor_InvalidJob() {
        assertThrows(IllegalArgumentException.class, () -> new User("Mikhail", 25, "", "London"));
    }

    @Test
    void testUserConstructor_InvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new User("Mikhail", 25, "Google", ""));
    }
}