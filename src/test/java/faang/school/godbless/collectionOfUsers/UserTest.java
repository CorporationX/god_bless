package faang.school.godbless.collectionOfUsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private Set<String> activities1;
    private Set<String> activities2;
    private Set<String> activities3;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {
        activities1 = new HashSet<>(Arrays.asList("Jumping", "Writing"));
        activities2 = new HashSet<>(Arrays.asList("Reading", "Swimming"));
        activities3 = new HashSet<>(Arrays.asList("Jumping", "Reading"));

        user1 = new User(1, "Mickeo", 15, activities1);
        user2 = new User(2, "Worta", 24, activities2);
        user3 = new User(3, "Dolly", 16, activities3);

    }

    @Test
    public void findHobbyLovers_successTest() {
        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> searchActivities = new HashSet<>(Arrays.asList("Jumping"));

        Map<User, String> result = User.findHobbyLovers(users, searchActivities);

        assertThat(result)
            .hasSize(2) // Ожидается, что два пользователя имеют совпадающую активность
            .containsKeys(user1, user3) // Пользователи 1 и 3 должны быть в результатах
            .containsValues("Jumping"); // Значение для совпадающей активности должно быть "Jumping"

    }


    @Test
    public void findHobbyLovers_zeroFind() {
        List<User> users = Arrays.asList(user1, user2);
        Set<String> searchActivities = new HashSet<>(Arrays.asList("Running"));

        Map<User, String> result = User.findHobbyLovers(users, searchActivities);

        assertThat(result).isEmpty(); // Ожидается, что нет пользователей с совпадающими активностями
    }


}
