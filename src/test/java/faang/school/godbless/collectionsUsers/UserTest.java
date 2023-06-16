package faang.school.godbless.collectionsUsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private List<User> users;
    private User userOne;
    private User userTwo;
    private User userThree;
    private User userFour;
    Set<String> baseActivities;

    @BeforeEach
    void setUp() {
        User.resetNextId();
        baseActivities = Set.of("Soccer", "Basketball", "Karate", "Box");
        userOne = new User("John", 30, Set.of("Soccer", "Gaming", "Reading"));
        userTwo = new User("Pole", 30, Set.of("Basketball", "Gaming", "Reading"));
        userThree = new User("Ralf", 30, Set.of("Karate", "Gaming", "Reading"));
        userFour = new User("Wayne", 30, Set.of("Box", "Gaming", "Reading"));
        users = List.of(userOne, userTwo, userThree, userFour);
    }

    @Test
    void testCreateUser() {
        assertEquals(0, userOne.getId());
        assertEquals(1, userTwo.getId());
        assertEquals(2, userThree.getId());
        assertEquals(3, userFour.getId());
    }

    @Test
    void shouldThrowException(){
        assertThrowsExactly(IllegalArgumentException.class, () -> new User("", 32, baseActivities));
        assertThrowsExactly(IllegalArgumentException.class, () -> new User("Tomas", 17, baseActivities));
    }

    @Test
    void findHobbyLovers() {
        Map<User, String> userHobby;
        Map<User, String> expectedResult = Map.of(
                userOne, "Soccer",
                userTwo, "Basketball",
                userThree, "Karate",
                userFour, "Box"
        );
        userHobby = User.findHobbyLovers(users, Set.of("Game"));
        assertTrue(userHobby.isEmpty());
        userHobby = User.findHobbyLovers(users, baseActivities);
        assertEquals(expectedResult, userHobby);
    }
}