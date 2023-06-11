package faang.school.godbless.age_group;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void groupUsersByAgeTest(){
        List<User> users = new ArrayList<>(List.of(
                new User("John", 28, "work1", "address1"),
                new User("Alice", 35, "work2", "address2"),
                new User("Bob", 35, "work3", "address3"),
                new User("Emily", 35, "work4", "address4")
        ));

        int expectedMapSize = 2;
        int resultedMapSize = User.groupUsersByAge(users).size();
        int expectedListSize = 3;
        int resultedListSize = User.getListSize(35);
        assertEquals(expectedMapSize,resultedMapSize);
        assertEquals(expectedListSize, resultedListSize);
    }

}
