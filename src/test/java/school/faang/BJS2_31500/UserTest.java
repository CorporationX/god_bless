package school.faang.BJS2_31500;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    //--Constructor Tests--
    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with valid data")
    void testUser_AllArgsConstructorInitializationValidData() {
        //arrange
        String name = "Anna";
        int age = 25;
        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Travel"));

        //act
        User anna = new User(name, age, hobbies);

        //assert
        assertEquals(name, anna.getName());
        assertEquals(age, anna.getAge());
        assertTrue(CollectionUtils.isEqualCollection(hobbies, anna.getHobbies()));
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with empty name")
    void testUser_AllArgsConstructorInitializationEmptyName() {
        //arrange
        String name = "    ";
        int age = 25;
        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Travel"));

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, hobbies));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with null name")
    void testUser_AllArgsConstructorInitializationNullName() {
        //arrange
        String name = null;
        int age = 25;
        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Travel"));

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, hobbies));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with invalid age")
    void testUser_AllArgsConstructorInitializationInvalidAge() {
        //arrange
        String name = "Anna";
        int age = -4;
        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Travel"));

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, hobbies));
        assertEquals("Invalid age. Must be at least 0 years old.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with null set of hobbies")
    void testUser_AllArgsConstructorInitializationNullHobbiesSet() {
        //arrange
        String name = "Anna";
        int age = 15;
        Set<String> hobbies = null;

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, hobbies));
        assertEquals("Invalid set of hobbies.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with set of hobbies of null")
    void testUser_AllArgsConstructorInitializationHobbiesSetOfNull() {
        //arrange
        String name = "Anna";
        int age = 15;
        Set<String> hobbies = new HashSet<>();
        hobbies.add(null);

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, hobbies));
        assertEquals("Invalid set of hobbies.", argumentException.getMessage());
    }

    //--findHobbyLovers method Tests--
    @Test
    @DisplayName("Testing findHobbyLovers method with valid data (users list and hobbies set have data)")
    void testUser_FindHobbyLoversWithValidData() {
        //arrange
        User Alex = new User("Alex", 30, new HashSet<>(List.of("Football", "Movies", "Travel")));
        User Catherine = new User("Catherine", 28, new HashSet<>(List.of("Drawing", "Swimming")));
        User Michael = new User("Michael", 25, new HashSet<>(List.of("Football", "Tennis", "Travel")));
        User Irina = new User("Irina", 35, new HashSet<>(List.of("Swimming", "Yoga", "Travel")));
        List<User> users = List.of(Alex, Catherine, Michael, Irina);

        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Tennis"));

        //act
        Map<User, Set<String>> usersHobbiesIntersection = User.findHobbyLovers(users, hobbies);

        //assert
        assertEquals(2, usersHobbiesIntersection.size());

        assertTrue(usersHobbiesIntersection.containsKey(Alex));
        assertTrue(CollectionUtils.isEqualCollection(
                new HashSet<>(List.of("Football", "Movies")),
                usersHobbiesIntersection.get(Alex)
        ));

        assertTrue(usersHobbiesIntersection.containsKey(Michael));
        assertTrue(CollectionUtils.isEqualCollection(
                new HashSet<>(List.of( "Tennis", "Football")),
                usersHobbiesIntersection.get(Michael)
        ));
    }

    @Test
    @DisplayName("Testing findHobbyLovers method with empty users list")
    void testUser_FindHobbyLoversWithEmptyUsersList() {
        //arrange
        User Alex = new User("Alex", 30, new HashSet<>(List.of("Football", "Movies", "Travel")));
        User Catherine = new User("Catherine", 28, new HashSet<>(List.of("Drawing", "Swimming")));
        User Michael = new User("Michael", 25, new HashSet<>(List.of("Football", "Tennis", "Travel")));
        User Irina = new User("Irina", 35, new HashSet<>(List.of("Swimming", "Yoga", "Travel")));
        List<User> users = List.of(Alex, Catherine, Michael, Irina);

        Set<String> hobbies = new HashSet<>();

        //act
        Map<User, Set<String>> usersHobbiesIntersection = User.findHobbyLovers(users, hobbies);

        //assert
        assertEquals(0, usersHobbiesIntersection.size());
    }

    @Test
    @DisplayName("Testing findHobbyLovers method with empty hobbies set")
    void testUser_FindHobbyLoversWithEmptyHobbiesSet() {
        //arrange
        List<User> users = new ArrayList<>();
        Set<String> hobbies = new HashSet<>(List.of("Football", "Movies", "Tennis"));

        //act
        Map<User, Set<String>> usersHobbiesIntersection = User.findHobbyLovers(users, hobbies);

        //assert
        assertEquals(0, usersHobbiesIntersection.size());
    }

    @Test
    @DisplayName("Testing findHobbyLovers method with null list of users")
    void testUser_FindHobbyLoversWithNullListOfUsers() {
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> User.findHobbyLovers(null, Set.of("Music")));
        assertEquals("Invalid users list.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing findHobbyLovers method with list of null users")
    void testUser_FindHobbyLoversWithListOfNullUsers() {
        //arrange
        List<User> users = new ArrayList<>();
        users.add(null);
        users.add(null);

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> User.findHobbyLovers(users, Set.of("Music")));
        assertEquals("Invalid users list.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing findHobbyLovers method with null set of hobbies")
    void testUser_FindHobbyLoversWithNullSetOfHobbies() {
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> User.findHobbyLovers(List.of(new User("Anna", 25, Set.of("Music"))), null));
        assertEquals("Invalid set of hobbies.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing findHobbyLovers method with null set of hobbies")
    void testUser_FindHobbyLoversWithSetOfNullHobby() {
        //arrange
        Set<String> hobbies = new HashSet<>();
        hobbies.add(null);

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> User.findHobbyLovers(List.of(new User("Anna", 25, Set.of("Music"))), hobbies));
        assertEquals("Invalid set of hobbies.", argumentException.getMessage());
    }
}