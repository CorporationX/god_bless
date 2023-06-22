package faang.school.godbless.age_group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    void groupUsersByAgeTest(){
        List<User> users = List.of(
                new User("John", 28, "Google", "London"),
                new User("Alice", 35, "Google", "London"),
                new User("Bob", 35, "Google", "London"),
                new User("Emily", 35, "Google", "London")
        );
        int expectedMapSize = 2;
        int expectedListSize = 1;
        int resultedMapSize = User.groupUsersByAge(users).size();
        int resultedListSize = User.getListSize(28);

        assertEquals(expectedMapSize,resultedMapSize);
        assertEquals(expectedListSize, resultedListSize);
    }

    @Test
    void addUnderageUserTest(){
        IllegalArgumentException exception = assertThrows(UserException.class,
                () -> new User("Vasya", 17, "Google", "London"));
        String expectedMessage = Message.UNDERAGE;

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addWrongAddressTest(){
        IllegalArgumentException exception = assertThrows(UserException.class,
                () -> new User("Vasya", 18, "Google", "Roma"));
        String expectedMessage = Message.WRONG_ADDRESS;

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addWrongWorkplaceTest(){
        IllegalArgumentException exception = assertThrows(UserException.class,
                () -> new User("Vasya", 18, "Yandex", "London"));
        String expectedMessage = Message.WRONG_WORKPLACE;

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addNullNameTest(){
        IllegalArgumentException exception = assertThrows(UserException.class,
                () -> new User(null, 18, "Google", "London"));
        String expectedMessage = Message.NULL_NAME;

        assertEquals(expectedMessage, exception.getMessage());
    }
}
