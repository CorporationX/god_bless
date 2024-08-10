package faang.school.godbless.BJS2_18587;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {
    List<User> users;

    @BeforeEach
    void setUp() {
        users = List.of(
                new User("Albert", 22, "Google", "Berlin.."),
                new User("Denis", 25, "Google", "Berlin"),
                new User("Victoria", 22, "Microsoft", "Washington"),
                new User("Elena", 26, "Microsoft", "Washington"),
                new User("Sergey", 27, "Microsoft", "Washington"),
                new User("Sara", 25, "Naumen", "Moscow"),
                new User("Maxim", 26, "Yandex", "Moscow")
        );
    }

    @Test
    void groupUsers() {
        var expectedMap = Map.of(22, List.of(
                        new User("Albert", 22, "Google", "Berlin.."),
                        new User("Victoria", 22, "Microsoft", "Washington")
                ),
                25, List.of(
                        new User("Denis", 25, "Google", "Berlin"),
                        new User("Sara", 25, "Naumen", "Moscow")
                ),
                26, List.of(
                        new User("Elena", 26, "Microsoft", "Washington"),
                        new User("Maxim", 26, "Yandex", "Moscow")
                ),
                27, List.of(
                        new User("Sergey", 27, "Microsoft", "Washington")
                )
        );
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        assertThat(groupedUsers).isEqualTo(expectedMap);
    }
}