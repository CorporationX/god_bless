package faang.school.godbless.sprint2.task4;

import faang.school.godbless.sprint2.task4.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User getUserWithHobbies(Set<String> hobbies) {
        User user = new User();
        user.setHobbies(hobbies);
        return user;
    }

    @Test
    void findHobbyLovers_shouldReturnEmptyResult() {
        User user = new User();
        Map<User, String> result = user.findHobbyLovers(List.of(
                getUserWithHobbies(Set.of("Sports")), getUserWithHobbies(Set.of("Video games"))),
                Set.of("Tourism")
        );
        assertTrue(result.isEmpty());
    }

    @Test
    void findHobbyLoversValidTest() {
        User sportsman = getUserWithHobbies(Set.of("Sports", "Tourism"));
        User gamer = getUserWithHobbies(Set.of("Video games", "Chess"));
        User blogger = getUserWithHobbies(Set.of("Blogging", "Tourism"));
        Map<User, String> result = new User().findHobbyLovers(
                List.of(sportsman, gamer, blogger),
                Set.of("Blogging", "Sports"));

        assertEquals(2, result.size());
        assertEquals("Sports", result.get(sportsman));
        assertEquals("Blogging", result.get(blogger));
    }
}