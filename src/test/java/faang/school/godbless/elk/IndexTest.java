package faang.school.godbless.elk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexTest {
    private Index index;

    @Test
    void shouldGiveSortedReport() {
        index = new Index();
        User user = new User("1", "alex");
        List<Query> queries = new ArrayList<>(Arrays.asList(new Query("1", "a", 300), new Query("2", "b", 100),
                new Query("3", "c", 200)));
        List.of();
        index.addUser(user, queries);
        String expected = "alex:\n" +
                "100:b\n" +
                "200:c\n" +
                "300:a\n";
        assertEquals(expected, index.indexUserReport(user));
    }

    @Test
    void shouldAddQuery() {
        index = new Index();
        User user = new User("1", "alex");
        List<Query> queries = new ArrayList<>(Arrays.asList(new Query("1", "a", 300), new Query("2", "b", 100),
                new Query("3", "c", 200)));
        index.addUser(user, queries);
        index.addQuery(user, new Query("4", "d", 50));
        String expected = "alex:\n" +
                "50:d\n" +
                "100:b\n" +
                "200:c\n" +
                "300:a\n";
        assertEquals(expected, index.indexUserReport(user));
    }

    @Test
    void shouldDeleteUser() {
        index = new Index();
        User user = new User("1", "alex");
        List<Query> queries = new ArrayList<>(Arrays.asList(new Query("1", "a", 300), new Query("2", "b", 100),
                new Query("3", "c", 200)));
        index.addUser(user, queries);
        index.removeUser(user);
        assertThrows(IllegalArgumentException.class, () -> index.indexUserReport(user));
    }

}