package dima.evseenko.group;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserTest {

    @Test
    void groupUsersFullList() {
        Map<Integer, List<User>> groupedUsers = User.groupUsers(getUsers());

        assertTrue(groupedUsers.get(22).contains(new User("Dima", 22, "Amazon", "New York")));
        assertTrue(groupedUsers.get(20).contains(new User("Kolya", 20, "Google", "New York")));
        assertTrue(groupedUsers.get(22).contains(new User("Olya", 22, "Google", "Amsterdam")));
    }

    @Test
    void groupUsersEmptyList() {
        Map<Integer, List<User>> groupedUsers = User.groupUsers(List.of());

        assertTrue(groupedUsers.isEmpty());
    }

    @Test
    void groupUsersNullList() {
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(null));
    }

    @Test
    void groupUsersValidUser(){
        Map<Integer, List<User>> groupedUsers = User.groupUsers(List.of(new User("Dima", 22, "Amazon", "New York")));

        assertTrue(groupedUsers.get(22).contains(new User("Dima", 22, "Amazon", "New York")));
    }

    @Test
    void groupUsersInvalidNameNull(){
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(List.of(new User(null, 22, "Amazon", "New York"))));
    }

    @Test
    void groupUsersInvalidNameEmptyOrBlank(){
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(List.of(new User("", 22, "Amazon", "New York"))));
    }

    @Test
    void groupUsersInvalidAge(){
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(List.of(new User("Dima", 9, "Amazon", "New York"))));
    }

    @Test
    void groupUsersInvalidJob(){
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(List.of(new User("Dima", 22, "Sber", "New York"))));
    }

    @Test
    void groupUsersInvalidAddress(){
        assertThrows(IllegalArgumentException.class, () -> User.groupUsers(List.of(new User("Dima", 22, "Amazon", "Warsaw"))));
    }

    private List<User> getUsers(){
        return Arrays.asList(
                new User("Dima", 22, "Amazon", "New York"),
                new User("Kolya", 20, "Google", "New York"),
                new User("Olya", 22, "Google", "Amsterdam"),
                new User("Vasya", 21, "Amazon", "New York"),
                new User("Vladislav", 19, "Uber", "London"),
                new User("Polina", 23, "Google", "Amsterdam"),
                new User("Igor", 20, "Amazon", "London")
        );
    }
}