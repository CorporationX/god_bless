package faang.school.godbless.BJS2_18384;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void findHobbyLovers() {
        Set<String> activities = Set.of("Java", "C");

        Set<String> activities1 = Set.of("A", "B", "C");
        Set<String> activities2 = Set.of("C++", "Java", "C#");
        Set<String> activities3 = Set.of("Java", "Python", "JavaScript");
        Set<String> activities4 = Set.of("D", "R", "Y");

        User user1 = new User(1, "Robert", 25, activities1);
        User user2 = new User(2, "Mikhail", 25, activities2);
        User user3 = new User(3, "Vlad", 25, activities3);
        User user4 = new User(4, "Inna", 25, activities4);
        List<User> users = List.of(user1, user2, user3, user4);

        Map<User, String> correctAnswer = Map.of(
                user1, "C",
                user2, "Java",
                user3, "Java"
        );

        Map<User, String> result = User.findHobbyLovers(users, activities);

        assertEquals(correctAnswer, result);
    }

    @Test
    void findHobbyLovers_EmptyActivities() {
        Set<String> emptyActivities = new HashSet<>();

        Set<String> activities1 = Set.of("Java", "Python", "JavaScript");
        Set<String> activities2 = Set.of("D", "R", "Y");

        User user1 = new User(1, "Robert", 25, activities1);
        User user2 = new User(2, "Mikhail", 25, activities2);
        List<User> users = List.of(user1, user2);

        Map<User, String> correctAnswer = new HashMap<>();

        Map<User, String> result = User.findHobbyLovers(users, emptyActivities);

        assertEquals(correctAnswer, result);
    }

    @Test
    void findHobbyLovers_EmptyUsers() {
        Set<String> activities = Set.of("Java", "C");
        List<User> users = new ArrayList<>();
        Map<User, String> correctAnswer = new HashMap<>();

        Map<User, String> result = User.findHobbyLovers(users, activities);

        assertEquals(correctAnswer, result);
    }
}