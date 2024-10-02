import org.junit.jupiter.api.Test;
import school.faang.User;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {

    @Test
    public void TestIfUserConstructed() {
        // arrange
        User expectedUser = new User("Notch", 50, "Google", "New York");

        // act
        String actualName = expectedUser.getName();
        int actualAge = expectedUser.getAge();
        String actualJob = expectedUser.getJob();
        String actualAddress = expectedUser.getAddress();

        // assert
        assertThrows(IllegalArgumentException.class, () -> new User("", 20, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Maksim", 4, "Google", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Alex", 20, "Zavod", "London"));
        assertThrows(IllegalArgumentException.class, () -> new User("Jeff", 20, "Google", "Moon"));

        assertEquals("Notch", actualName, "The name must be Notch");
        assertEquals(50, actualAge, "The age must be 50");
        assertEquals("Google", actualJob, "The job must be Google");
        assertEquals("New York", actualAddress, "The address must be New York");
    }

    @Test
    public void testIfGroupedByAge() {
        // arrange
        User user1 = new User("Maksim", 20, "No job", "Moscow");
        User user2 = new User("Aleksandr", 30, "Factory", "Novgorod");
        User user3 = new User("Katya", 20, "Student", "Tver");
        User user4 = new User("John", 30, "Businessman", "Klin");
        User user5 = new User("Shrek", 25, "Saving the world", "Swamp");

        List<User> usersList = List.of(user1, user2, user3, user4, user5);

        // act
        HashMap<Integer, List<User>> actual = User.groupUsers(usersList);

        // assert
        assertEquals(2, actual.get(20).size());
        assertEquals(2, actual.get(30).size());
        assertEquals(1, actual.get(25).size());

        assertEquals("Maksim", actual.get(20).get(0).getName());
        assertEquals("Katya", actual.get(20).get(1).getName());
        assertEquals("Aleksandr", actual.get(30).get(0).getName());
        assertEquals("John", actual.get(30).get(1).getName());
    }
}
