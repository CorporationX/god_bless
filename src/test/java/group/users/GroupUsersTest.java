package group.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupUsersTest {
    public static List<User> ungroupedUserList;

    @BeforeEach
    void setup() {
        ungroupedUserList = new ArrayList<>();
    }

    @Test
    void testGroupUsers() {
        User userVasya = new User("Vasya", 21, "Google", "Amsterdam");
        User userKolya = new User("Kolya", 21, "Uber", "London");
        User userSanya = new User("Sanya", 24, "Amazon", "New York");
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
    void testUserNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 21, "Google", "London"));
    }

    @Test
    void testUserAgeValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("Vasya", 17, "Uber", "Amsterdam"));
    }

    @Test
    void testUserCompanyValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("Vanya", 27, "Invalid company", "London"));
    }

    @Test
    void testUserAddressValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("Sanya", 25, "Amazon", "Invalid address"));
    }
}
