package school.faang.usercollection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.faang.usercollection.User.findHobbyLovers;

public class UserCollectionTest {

    @Test
    @DisplayName("Each user has 1 matching activity")
    public void testUserSingleHobbyMatch() {
        List<User> users = List.of(
                new User(1, "User1", 25, new HashSet<>(Set.of("Running", "Swimming", "Cycling", "Hiking", "Yoga"))),
                new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting"))),
                new User(3, "User3", 35, new HashSet<>(Set.of("Cooking", "Reading", "Grilling", "Roasting", "Frying")))
        );

        Set<String> hobbies = new HashSet<>(Set.of("Writing", "Running", "Roasting"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(3, hobbyLovers.size());
        assertEquals("Running", hobbyLovers.get(new User(1, "User1", 25, new HashSet<>(Set.of("Running", "Swimming", "Cycling", "Hiking", "Yoga")))));
        assertEquals("Writing", hobbyLovers.get(new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting")))));
        assertEquals("Roasting", hobbyLovers.get(new User(3, "User3", 35, new HashSet<>(Set.of("Cooking", "Reading", "Grilling", "Roasting", "Frying")))));
    }

    @Test
    @DisplayName("Each user has several matching activity")
    public void testUserMultipleHobbyMatch() {
        List<User> users = List.of(
                new User(1, "User1", 25, new HashSet<>(Set.of("Running", "Swimming", "Cycling", "Hiking", "Yoga"))),
                new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting"))),
                new User(3, "User3", 35, new HashSet<>(Set.of("Cooking", "Reading", "Grilling", "Roasting", "Frying")))
        );

        Set<String> hobbies = new HashSet<>(Set.of("Drawing", "Running", "Writing", "Swimming", "Cycling", "Hiking"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(2, hobbyLovers.size());
        assertEquals("Hiking", hobbyLovers.get(new User(1, "User1", 25, new HashSet<>(Set.of("Running", "Swimming", "Cycling", "Hiking", "Yoga")))));
        assertEquals("Writing", hobbyLovers.get(new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting")))));
    }

    @Test
    @DisplayName("Users have no matching activity")
    public void testUserNoHobbyMatch() {
        List<User> users = List.of(
                new User(1, "User1", 25, new HashSet<>(Set.of("Running", "Swimming", "Cycling", "Hiking", "Yoga"))),
                new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting"))),
                new User(3, "User3", 35, new HashSet<>(Set.of("Cooking", "Reading", "Grilling", "Roasting", "Frying")))
        );

        Set<String> hobbies = new HashSet<>(Set.of("Exercising", "Weightlifting", "Cardio", "Stretching", "Pilates"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(0, hobbyLovers.size());
    }

    @Test
    @DisplayName("Empty Hobby list provided")
    public void testUserEmptyHobbyList() {
        List<User> users = List.of(
                new User(1, "User1", 25, new HashSet<>(Set.of("Running", "Swimming", "Cycling", "Hiking", "Yoga"))),
                new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting"))),
                new User(3, "User3", 35, new HashSet<>(Set.of("Cooking", "Reading", "Grilling", "Roasting", "Frying")))
        );

        Set<String> hobbies = new HashSet<>();

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(0, hobbyLovers.size());
    }

    @Test
    @DisplayName("Users have empty Activity list")
    public void testUserEmptyUserActivityLIst() {
        List<User> users = List.of(
                new User(1, "User1", 25, new HashSet<>()),
                new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting"))),
                new User(3, "User3", 35, new HashSet<>(Set.of("Cooking", "Reading", "Grilling", "Roasting", "Frying")))
        );

        Set<String> hobbies = new HashSet<>(Set.of("Drawing", "Running", "Testing"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(1, hobbyLovers.size());
        assertEquals("Drawing", hobbyLovers.get(new User(2, "User2", 15, new HashSet<>(Set.of("Reading", "Writing", "Painting", "Drawing", "Sculpting")))));
    }

    @Test
    @DisplayName("Empty Activity list and Hobby list")
    public void testUserEmptyLists() {
        List<User> users = List.of(
                new User(1, "User1", 25, new HashSet<>())
        );

        Set<String> hobbies = new HashSet<>();

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(0, hobbyLovers.size());
    }

    @Test
    @DisplayName("Empty Activity list and Hobby list")
    public void testUserEmptyUserList() {
        List<User> users = new ArrayList<>();

        Set<String> hobbies = new HashSet<>(Set.of("Drawing", "Running", "Testing"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        assertEquals(0, hobbyLovers.size());
    }

}
