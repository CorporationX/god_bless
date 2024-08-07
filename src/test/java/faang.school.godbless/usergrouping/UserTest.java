package faang.school.godbless.usergrouping;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private List<User> users;
    private Map<Integer, List<User>> groupedUsers;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>(List.of(
                new User("Alice", 30, "Company A", "Address 1"),
                new User("Bob", 25, "Company B", "Address 2"),
                new User("Charlie", 30, "Company C", "Address 3"),
                new User("David", 25, "Company D", "Address 4"),
                new User("Eve", 35, "Company E", "Address 5"))
        );
        groupedUsers = User.groupUsers(users);
    }

    @AfterEach
    public void tearDown() {
        users.clear();
        groupedUsers.clear();
    }

    @Test
    @DisplayName("Проверка результирующей HashMap'ы на размер и null")
    public void testGroupedUsersForSizeAndNull() {
        assertAll(
                () -> assertNotNull(groupedUsers),
                () -> assertEquals(3, groupedUsers.size())
        );
    }

    @Test
    @DisplayName("Проверка группы 30-летних")
    public void testAge30Group() {
        List<User> age30Group = groupedUsers.get(30);

        assertAll(
                () -> assertNotNull(age30Group),
                () -> assertEquals(2, age30Group.size()),
                () -> assertThat(groupedUsers.get(30)).extracting(User::getName)
                        .containsExactlyInAnyOrder("Alice", "Charlie")
        );
    }

    @Test
    @DisplayName("Проверка пустого списка пользователей")
    public void testEmptyUserList() {
        List<User> emptyUsers = new ArrayList<>();
        Map<Integer, List<User>> emptyGroupedUsers = User.groupUsers(emptyUsers);

        assertAll(
                () -> assertNotNull(emptyGroupedUsers),
                () -> assertTrue(emptyGroupedUsers.isEmpty())
        );
    }

    @Test
    @DisplayName("Проверка наличия всех уникальных возрастов")
    public void testAllUniqueAgesPresent() {
        Set<Integer> uniqueAges = users.stream()
                .map(User::getAge)
                .collect(Collectors.toSet());

        assertAll(
                () -> assertNotNull(groupedUsers),
                () -> uniqueAges.forEach(age ->
                        assertTrue(groupedUsers.containsKey(age))
                )
        );
    }
}
