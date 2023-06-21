package faang.school.godbless.age_group;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void groupUsersByAgeTest(){
        List<User> users = List.of(
                new User("John", 28, "work1", "address1"),
                new User("Alice", 35, "work2", "address2"),
                new User("Bob", 35, "work3", "address3"),
                new User("Emily", 35, "work4", "address4")
        );

        int expectedMapSize = 2;
        int expectedListSize = 1;
        int resultedListSize = User.getListSize(28);
        int resultedMapSize = User.groupUsersByAge(users).size();

        assertEquals(expectedMapSize,resultedMapSize);
        assertEquals(expectedListSize, resultedListSize);
    }
}