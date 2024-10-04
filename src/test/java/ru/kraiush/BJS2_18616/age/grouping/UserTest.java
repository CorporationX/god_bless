package ru.kraiush.BJS2_18616.age.grouping;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.age.grouping.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    @DisplayName("Позитивный кейс")
    public void testGroupUsers() {
        //arrange
        User user1 = new User("Nikola", 21, "Google", "London");
        User user2 = new User("Nikita", 21, "Google", "London");
        User user3 = new User("Georgy", 22, "Uber", "New York");
        User user4 = new User("Alisa", 22, "Amazon", "Amsterdam");
        User user5 = new User("Maksim", 30, "Amazon", "Amsterdam");
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
        User user1 = new User("Nikola", 21, "Google", "Amsterdam");
        List<User> users = List.of(user1);
        Map<Integer, List<User>> expected = Map.of(21, users);

        //act
        Map<Integer, List<User>> actual = User.groupUsers(users);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Создание пользователя с корректными данными")
    public void createUser_withCorrectData() {
        //arrange & act
        User user = new User("Nikola", 21, "Google", "London");

        //assert
        assertNotNull(user);
        assertEquals("Nikola", user.getName());
        assertEquals(21, user.getAge());
        assertEquals("Google", user.getPlaceOfWork());
        assertEquals("London", user.getAddress());
    }

    @Test
    @DisplayName("Создание пользователя с пустым именем")
    public void createUser_withEmptyName_throwsIllegalArgumentException() {
        //arrange & act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new User("", 21, "Google", "London"));
        assertThrows(IllegalArgumentException.class,
                () -> new User(" ", 21, "Google", "London"));
    }

    @Test
    @DisplayName("Создание пользователя с null, вместо имени")
    public void createUser_withNullName_throwsIllegalArgumentException() {
        //arrange & act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new User(null, 21, "Google", "London"));
    }

    @Test
    @DisplayName("Создание пользователя младше 18")
    public void createUser_withAgeUnderEighteen_throwsIllegalArgumentException() {
        //arrange & act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new User("Nikola", 14, "Google", "London"));
    }

    @Test
    @DisplayName("Создание пользователя, работающего в галере")
    public void createUser_withNonValidPlaceOfWork_throwsIllegalArgumentException() {
        //arrange & act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new User("Nikola", 14, "ItGalera", "London"));
    }

    @Test
    @DisplayName("Создание пользователя с невалидным адресом")
    public void createUser_withNonValidAddress_throwsIllegalArgumentException() {
        //arrange & act & assert
        assertThrows(IllegalArgumentException.class,
                () -> new User("Nikola", 14, "Google", "Moscow"));
    }
}
