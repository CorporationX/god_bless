package index.elk.test;

import index.elk.Main;
import index.elk.Query;
import index.elk.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndexTest {
    @BeforeEach
    void setUp() {
        Main.getUserQueries().clear();
    }

    private LocalDateTime getRandomDateTime() {
        Random rand = new Random();
        return LocalDateTime.now().minusSeconds(rand.nextInt(
                10 * 24 * 60 * 60
        ));
    }

    @Test
    @DisplayName("Testing addNewUser method")
    void indexTest_addNewUser() {
        User user = new User("Vanya");
        List<Query> queries = List.of(new Query("aboba", getRandomDateTime()));

        Main.addNewUser(user, queries);

        assertTrue(Main.getUserQueries().containsKey(user));
    }

    @Test
    @DisplayName("Testing addNewUser method with added user")
    void indexTest_addAddedUser() {
        User user1 = new User("Vanya");
        LocalDateTime date = getRandomDateTime();
        List<Query> queries1 = List.of(new Query("aboba", date));
        User user2 = new User("Vanya");
        List<Query> queries2 = List.of(new Query("aboba", date));
        Main.addNewUser(user1, queries1);

        Main.addNewUser(user2, queries2);

        assertEquals(1, Main.getUserQueries().size());
    }

    @Test
    @DisplayName("Testind addNewUser method with empty queries list")
    void indexTest_addNewUserWithEmptyQueries() {
        User user1 = new User("Vanya");

        Main.addNewUser(user1, new ArrayList<>());

        assertTrue(Main.getUserQueries().isEmpty());
    }

    @Test
    @DisplayName("Testing addNewUser method with null arguments")
    void indexTest_addNewUserWithNullArguments() {
        User user = new User("Vanya");
        List<Query> queries = List.of(new Query("aboba", getRandomDateTime()));

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addNewUser(null, queries)
                ),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addNewUser(user, null)
                )
        );
    }

    @Test
    @DisplayName("Testind addQueryForUser method")
    void indexTest_addQuery() {
        User user = new User("Vanya");
        List<Query> queries = new ArrayList<>(List.of(new Query("aboba", getRandomDateTime())));
        Query newQuery = new Query("boba", getRandomDateTime());
        Main.addNewUser(user, queries);

        Main.addQueryForUser(user, newQuery);

        assertAll(
                () -> assertEquals(2, Main.getUserQueries().get(user).size()),
                () -> assertTrue(Main.getUserQueries().get(user).contains(newQuery))
        );
    }

    @Test
    @DisplayName("Testing addQueryForUser method for user not in index")
    void indexTest_addQueryForUserNotInIndex() {
        User user = new User("Vanya");
        Query newQuery = new Query("boba", getRandomDateTime());

        Main.addQueryForUser(user, newQuery);

        assertTrue(Main.getUserQueries().isEmpty());
    }

    @Test
    @DisplayName("Testing addQueryForUser with null arguments")
    void indexTest_addQueryWithNullArguments() {
        User user = new User("Vanya");
        Query newQuery = new Query("boba", getRandomDateTime());

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addQueryForUser(null, newQuery)
                ),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addQueryForUser(user, null)
                )
        );
    }

    @Test
    @DisplayName("Testind removeUser method")
    void indexTest_removeUserFromIndex() {
        User user = new User("Vanya");
        List<Query> queries = new ArrayList<>(List.of(new Query("aboba", getRandomDateTime())));
        Main.addNewUser(user, queries);

        Main.removeUser(user);

        assertTrue(Main.getUserQueries().isEmpty());
    }

    @Test
    @DisplayName("Testing removeUser method with user not in index")
    void indexTest_removeUserNotInIndex() {
        User user1 = new User("Vanya");
        User user2 = new User("Petya");
        List<Query> queries = new ArrayList<>(List.of(new Query("aboba", getRandomDateTime())));
        Main.addNewUser(user1, queries);

        Main.removeUser(user2);

        assertEquals(1, Main.getUserQueries().size());
    }

    @Test
    @DisplayName("Testing removeUser method with null arguments")
    void indexTest_removeUserWithNullArguments() {
        assertThrows(NullPointerException.class, () -> Main.removeUser(null));
    }

    @Test
    @DisplayName("Testing printUserQueriesOrdered with null arguments")
    void indexTest_printUserQueriesWithNullArguments() {
        assertThrows(NullPointerException.class, () -> Main.printUserQueriesOrdered(null));
    }
}
