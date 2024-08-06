package faang.school.godbless.task_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    @ParameterizedTest
    @MethodSource("groupUsersProvider")
    @DisplayName("Group User Test")
    void groupUsers(List<User> users, Map<Integer, List<User>> expectedMap) {

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        assertThat(groupedUsers).isEqualTo(expectedMap);

    }

    private Stream<Arguments> groupUsersProvider() {
        return Stream.of(Arguments.of(
                List.of(
                        new User("Albert", 22, "Google", "Berlin.."),
                        new User("Denis", 25, "Google", "Berlin"),
                        new User("Victoria", 22, "Microsoft", "Washington"),
                        new User("Elena", 26, "Microsoft", "Washington"),
                        new User("Sergey", 27, "Microsoft", "Washington"),
                        new User("Sara", 25, "Naumen", "Moscow"),
                        new User("Maxim", 26, "Yandex", "Moscow")
                ),
                Map.of(22, List.of(
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

                )));
    }
}