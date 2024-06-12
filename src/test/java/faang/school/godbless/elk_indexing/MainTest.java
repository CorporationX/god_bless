package faang.school.godbless.elk_indexing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private User user1;
    private Query query1;
    private Query query2;

    @BeforeEach
    void setUp() {
        main = new Main();
        user1 = new User("user1", 1);
        query1 = new Query(1, "query1", Instant.now());
        query2 = new Query(2, "query2", Instant.now().plusSeconds(10));
    }

    @Test
    void spyOnUser_shouldAddUser() {
        main.spyOnUser(user1, Arrays.asList(query1, query2));
        assertEquals(2, main.getQueryMap().get(user1).size());
    }

    @Test
    void updateUser_shouldAddQueryForUser() {
        main.spyOnUser(user1, new ArrayList<>(Collections.singletonList(query1)));
        main.updateUser(user1, query2);
        assertEquals(2, main.getQueryMap().get(user1).size());
    }

    @Test
    void youBeingSuedBy_shouldRemoveUser() {
        main.spyOnUser(user1, Arrays.asList(query1, query2));
        main.youBeingSuedDeleteUserData(user1);
        assertFalse(main.getQueryMap().containsKey(user1));
    }

    @Test
    void report_shouldPrintMap() {
        main.spyOnUser(user1, Arrays.asList(query1, query2));
        main.report(); // Verify the output manually or use a logging framework to capture the output
    }

    @Test
    void actEvilAndSeeUsersSearchHistory_shouldPrintSortedQueries() {
        main.spyOnUser(user1, Arrays.asList(query2, query1));
        main.actEvilAndSeeUsersSearchHistory(); // Verify the output manually or use a logging framework to capture the output
    }
}