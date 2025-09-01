package school.faang.collect_users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

class UserTest {
    private final User userService = new User();

    @Test
    void testUserMethodFindHobbyLovers() {
        User user1 = new User(UUID.randomUUID(), "Миша", 32, List.of("гитара", "сноуборд", "java", "хайкинг"));
        User user2 = new User(UUID.randomUUID(), "Влад", 28, List.of("java", "faang"));
        User user3 = new User(UUID.randomUUID(), "Петя", 22, List.of("java", "бокс", "аниме"));
        User user4 = new User(UUID.randomUUID(), "Маша", 28, List.of("java", "кулинария", "фанфики", "аниме"));
        User user5 = new User(UUID.randomUUID(), "Катя", 28, List.of("java", "кино", "рпг"));
        User user6 = new User(UUID.randomUUID(), "Оля", 28, List.of("python", "хайкинг"));

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Map<User, String> hobbyLovers = userService.findHobbyLovers(users, List.of("хайкинг", "аниме"));

        Assertions.assertEquals("хайкинг", hobbyLovers.get(user1));
        Assertions.assertEquals("хайкинг", hobbyLovers.get(user6));
        Assertions.assertEquals("аниме", hobbyLovers.get(user3));
        Assertions.assertEquals("аниме", hobbyLovers.get(user4));

        Assertions.assertNull(hobbyLovers.get(user2));
        Assertions.assertNull(hobbyLovers.get(user5));
    }
}