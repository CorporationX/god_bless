package faang.school.godbless.register.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class UserTest {

    @Test
    void testGroupUsers() {
        User timofei = new User("Timofei", 30, "Amazon", "London");
        User maria = new User("Maria", 24, "Google", "New York");
        User roman = new User("Roman", 24, "Uber", "Amsterdam");

        List<User> users = List.of(timofei, maria, roman);

        Map<Integer, List<User>> ageUserMap = User.groupUsers(users);
        Assertions.assertEquals(List.of(timofei), ageUserMap.get(30));
        Assertions.assertEquals(List.of(maria, roman), ageUserMap.get(24));
    }

    @Test
    void testIfEverythingValid() {
        Assertions.assertDoesNotThrow(() -> new User("Tim", 18, "Amazon", "London"));
    }

    @Test
    void testAgeNotValid() {
        IllegalArgumentException nameException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", 22, "Amazon", "London"));
        Assertions.assertEquals(nameException.getMessage(), "Name can't be null or empty");

        IllegalArgumentException ageException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Tim", 17, "Amazon", "London"));
        Assertions.assertEquals(ageException.getMessage(), "Age can't be less than 18");

        IllegalArgumentException placeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Tim", 18, "Sber", "London"));
        Assertions.assertEquals(placeException.getMessage(), "Work place is not valid");

        IllegalArgumentException addressException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Tim", 18, "Amazon", "Paris"));
        Assertions.assertEquals(addressException.getMessage(), "Address is not valid");
    }
}

