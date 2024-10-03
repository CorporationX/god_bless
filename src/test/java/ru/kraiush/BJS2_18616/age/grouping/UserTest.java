package ru.kraiush.BJS2_18616.age.grouping;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.age.grouping.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    @DisplayName("Позитивный кейс")
    public void testGroupUsers() {
        //arrange
        User user1 = new User("Nikola", 21, "Ya.Eats", "Lermontova str.");
        User user2 = new User("Nikita", 21, "Ya.Eats", "Grushevskaya str.");
        User user3 = new User("Georgy", 22, "Ya.Eats", "Sevastopolskaya str.");
        User user4 = new User("Alisa", 22, "Ya.Eats", "Lermontova str.");
        User user5 = new User("Maksim", 30, "Ya.Eats", "Lermontova str.");
        List<User> users = List.of(user1, user2, user3, user4, user5);
        Map<Integer, List<User>> expected = Map.of(
                21, List.of(user1, user2),
                22, List.of(user3, user4),
                30, List.of(user5)
        );

        //act
        Map<Integer, List<User>> actual = User.groupUsers(users);

        //assert
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Пустой список")
    public void groupUsers_withEmptyList_returnsEmptyMap() {
        //arrange & act
        Map<Integer, List<User>> expected = Collections.emptyMap();
        Map<Integer, List<User>> actual = User.groupUsers(new ArrayList<>());

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Список из одного элемента")
    public void groupUsers_withSingleUser_returnsEmptyMap() {
        //arrange
        User user1 = new User("Nikola", 21, "Ya.Eats", "Lermontova str.");
        List<User> users = List.of(user1);
        Map<Integer, List<User>> expected = Map.of(21, users);

        //act
        Map<Integer, List<User>> actual = User.groupUsers(users);

        //assert
        assertEquals(expected, actual);
    }
}
