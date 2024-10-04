package ru.kraiush.BJS2_18616.collecting.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.collecting.users.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    @DisplayName("Поиск пользователей с общими интересами - позитивный случай")
    public void findHobbyLovers_withCorrectData() {
        //arrange
        User user1 = new User(1L, "Коля", 21, Set.of("спорт зал", "программирование", "прогулки"));
        User user2 = new User(1L, "Никита", 21, Set.of("футбол", "программирование", "теннис"));
        User user3 = new User(1L, "Костя", 21, Set.of("прогулки", "спорт зал", "просмотр фильмов"));
        User user4 = new User(1L, "Аноним", 21, Set.of("бухать в подъзде"));
        List<User> users = List.of(user2, user3, user4);

        //act
        Map<User, String> actual = user1.findHobbyLovers(users, user1.getActivities());

        //assert
        assertTrue(actual.containsKey(user2) && actual.containsKey(user3));
        assertEquals("программирование", actual.get(user2));
        assertEquals("прогулки", actual.get(user3));
    }

    @Test
    @DisplayName("Поиск пользователей с общими интересами - пустой список")
    public void findHobbyLovers_withEmptyList_returnsEmptyMap() {
        //arrange
        User user1 = new User(1L, "Коля", 21, Set.of("спорт зал", "программирование", "прогулки"));
        List<User> users = new ArrayList<>();
        Map<User, String> expected = Collections.emptyMap();

        //act
        Map<User, String> actual = user1.findHobbyLovers(users, user1.getActivities());

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск пользователей с общими интересами - список null")
    public void findHobbyLovers_withListNull_throwsNullPointerException() {
        //arrange
        User user1 = new User(1L, "Коля", 21, Set.of("спорт зал", "программирование", "прогулки"));

        //act & assert
        assertThrows(NullPointerException.class, () -> user1.findHobbyLovers(null, user1.getActivities()));
    }

    @Test
    @DisplayName("Поиск пользователей с общими интересами - множество активностей null")
    public void findHobbyLovers_withSetNull_throwsNullPointerException() {
        //arrange
        User user1 = new User(1L, "Коля", 21, Set.of("спорт зал", "программирование", "прогулки"));
        User user2 = new User(1L, "Никита", 21, Set.of("футбол", "программирование", "теннис"));
        User user3 = new User(1L, "Костя", 21, Set.of("прогулки", "спорт зал", "просмотр фильмов"));
        User user4 = new User(1L, "Аноним", 21, Set.of("бухать в подъзде"));
        List<User> users = List.of(user2, user3, user4);

        //act & assert
        assertThrows(NullPointerException.class, () -> user1.findHobbyLovers(users, null));
    }
}
