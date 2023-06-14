package Task4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask4 {

    @Test
    void getHobbiesTest() {
        List<User> userList = List.of(
                new User(1, "Вася", 15, List.of("Игры", "Плаванье", "Бег")),
                new User(2, "Галина", 15, List.of("Прогулки", "Музыка", "Фильмы")),
                new User(3, "Олег", 15, List.of("Фильмы", "Паркур", "Игры")),
                new User(4, "Петр", 15, List.of("Музыка", "Путешествия", "Игры")));
        List<String> hobbyList = List.of("Паркур", "Фильмы", "Прогулки");
        Map<User, String> map = User.findHobbyLovers(userList, hobbyList);
        int expectedMapSize = 2;

        assertEquals(expectedMapSize, map.size());
        assertTrue(map.containsValue("Фильмы"));
        assertTrue(map.containsValue("Паркур"));
    }
}
