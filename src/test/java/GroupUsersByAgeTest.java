import groupUsersByAge.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupUsersByAgeTest {
    public static List<User> ungroupedUserList;

    @BeforeEach
    void setup() {
        ungroupedUserList = new ArrayList<>();
    }

    @Test
    void testGroupUsers() {
        User userVasya = new User("Vasya", 21, "Google", "house1");
        User userKolya = new User("Kolya", 21, "Apple", "house2");
        User userSanya = new User("Sanya", 24, "Sony", "house14");
        ungroupedUserList.add(userVasya);
        ungroupedUserList.add(userKolya);
        ungroupedUserList.add(userSanya);

        Map<Integer, List<User>> groupedUsers = User.groupUsersByAge(ungroupedUserList);

        assertTrue(groupedUsers.get(21).contains(userVasya));
        assertTrue(groupedUsers.get(21).contains(userKolya));
        assertTrue(groupedUsers.get(24).contains(userSanya));

        assertEquals(2, groupedUsers.size());
    }

    @Test
    void testExceptionThrowsWithIncorrectUserData() {
        User userVasya = new User("Vasya", 21, "Google", "house1");
        User userVanya = new User("Vanya", 0, "Google", "house1");
        ungroupedUserList.add(userVasya);
        ungroupedUserList.add(userVanya);

        assertThrows(IllegalArgumentException.class, () -> User.groupUsersByAge(ungroupedUserList));
    }
}
