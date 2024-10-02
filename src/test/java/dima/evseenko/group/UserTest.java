package dima.evseenko.group;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsersFullList() {
        Map<Integer, List<User>> groupedUsers = User.groupUsers(getUsers());
        System.out.println(groupedUsers);

        assertTrue(groupedUsers.get(22).contains(new User("Dima", 22, "Amazon", "Poland")));
        assertTrue(groupedUsers.get(20).contains(new User("Kolya", 20, "Randstad", "Poland")));
        assertTrue(groupedUsers.get(22).contains(new User("Olya", 22, "Google", "England")));
    }

    @Test
    void groupUsersEmptyList() {
        Map<Integer, List<User>> groupedUsers = User.groupUsers(List.of());

        assertTrue(groupedUsers.isEmpty());
    }

    private List<User> getUsers(){
        return Arrays.asList(
                new User("Dima", 22, "Amazon", "Poland"),
                new User("Kolya", 20, "Randstad", "Poland"),
                new User("Olya", 22, "Google", "England"),
                new User("Vasya", 21, "DNS", "Russia"),
                new User("Vladislav", 19, "Uber", "Amsterdam"),
                new User("Polina", 23, "Amazon", "Poland"),
                new User("Igor", 20, "Amazon", "Poland")
        );
    }
}