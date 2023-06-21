package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GroupTest {
    private User user;
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;

    @BeforeEach
    public void setUp(){
        user = new User("Pasha", 25, "Manager", "Kaliningrad");
        user1 = new User("Ivan", 18, "Barman", "Soho");
        user2 = new User("Masha", 22, "Artist", "Madrid");
        user3 = new User("Kolya", 18, "Driver", "Paris");
        user4 = new User("Natasha", 22, "Student", "Moscow");
        user5 = new User("Max", 21, "Boxer", "Rome");
    }

    @Test
    private void testUsersGroupedByAge(){
        Map<Integer, List<User>> result = user.groupUsers(createUsers());
        assertEquals(expectedResultOfGroup(), result);
    }

    private List<User> createUsers(){
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }
    private Map<Integer, List<User>> expectedResultOfGroup(){
        Map<Integer, List<User>> result = new HashMap<>();
        List<User> users18 = new ArrayList<>();
        List<User> users22 = new ArrayList<>();
        List<User> users21 = new ArrayList<>();
        users18.add(user1);
        users18.add(user3);
        users21.add(user5);
        users22.add(user2);
        users22.add(user4);
        result.put(18, users18);
        result.put(22, users22);
        result.put(21, users21);
        return result;
    }}
