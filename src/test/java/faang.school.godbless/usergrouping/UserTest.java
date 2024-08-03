package faang.school.godbless.usergrouping;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    private List<User> users;
    private Map<Integer, List<User>> groupedUsers;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
        users.add(new User("Alice", 30, "Company A", "Address 1"));
        users.add(new User("Bob", 25, "Company B", "Address 2"));
        users.add(new User("Charlie", 30, "Company C", "Address 3"));
        users.add(new User("David", 25, "Company D", "Address 4"));
        users.add(new User("Eve", 35, "Company E", "Address 5"));

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
    @DisplayName("Проверка группы 25-летних")
    public void testAge25Group() {
        List<User> age25Group = groupedUsers.get(25);

        assertAll(
                () -> assertNotNull(age25Group),
                () -> assertEquals(2, age25Group.size()),
                () -> assertThat(groupedUsers.get(25)).extracting(User::getName)
                        .containsExactlyInAnyOrder("Bob", "David")
        );
    }

    @Test
    @DisplayName("Проверка группы 35-летних")
    public void testAge35Group() {
        List<User> age35Group = groupedUsers.get(35);

        assertAll(
                () -> assertNotNull(age35Group),
                () -> assertEquals(1, age35Group.size()),
                () -> assertThat(groupedUsers.get(35)).extracting(User::getName)
                        .containsExactly("Eve")
        );
    }
}
