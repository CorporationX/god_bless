package faang.school.godbless.javahashmap.index;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndexElkTest {

    private static final User USER_1 = new User(1, "USER_1");
    private static final User USER_2 = new User(2, "USER_2");
    private static final User USER_3 = new User(3, "USER_2");
    private static final Query QUERY_1_1 = new Query(1, "query1_1 content", 221);
    private static final Query QUERY_1_2 = new Query(2, "query1_2 content", 112);
    private static final Query QUERY_2_1 = new Query(3, "query2_1 content", 3);
    private static final Query QUERY_3_1 = new Query(4, "query3_1 content", 4);
    private static final String ALL_USERS_INDEX_INFO = """
            User: User(id=2, name=USER_2)\r
               Query: Query(id=3, content=query2_1 content, timestamp=3)\r
            User: User(id=3, name=USER_2)\r
               Query: Query(id=4, content=query3_1 content, timestamp=4)\r
            User: User(id=1, name=USER_1)\r
               Query: Query(id=1, content=query1_1 content, timestamp=221)\r
               Query: Query(id=2, content=query1_2 content, timestamp=112)\r
            """;
    private static final String USER_2_INDEX_INFO = """
            User: User(id=1, name=USER_1)\r
               Query: Query(id=2, content=query1_2 content, timestamp=112)\r
               Query: Query(id=1, content=query1_1 content, timestamp=221)\r
            """;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Test
    void testAddUser() {
        IndexElk indexElk = new IndexElk();

        indexElk.addUser(USER_1, new ArrayList<>(List.of(QUERY_1_1, QUERY_1_2)));
        indexElk.addUser(USER_2, new ArrayList<>(List.of(QUERY_2_1)));
        indexElk.addUser(USER_3, new ArrayList<>(List.of(QUERY_3_1)));

        Map<User, List<Query>> index = indexElk.getIndex();
        assertEquals(3, index.size());
        assertTrue(index.containsKey(USER_1));
        assertTrue(index.containsKey(USER_2));
        assertTrue(index.containsKey(USER_3));

        List<Query> queriesForUSER_1 = index.get(USER_1);
        assertEquals(2, queriesForUSER_1.size());
        assertTrue(queriesForUSER_1.contains(QUERY_1_1));
        assertTrue(queriesForUSER_1.contains(QUERY_1_2));

        List<Query> queriesForUSER_2 = index.get(USER_2);
        assertEquals(1, queriesForUSER_2.size());
        assertTrue(queriesForUSER_2.contains(QUERY_2_1));

        List<Query> queriesForUSER_3 = index.get(USER_3);
        assertEquals(1, queriesForUSER_3.size());
        assertTrue(queriesForUSER_3.contains(QUERY_3_1));
    }

    @Test
    void testAddQuery() {
        IndexElk indexElk = new IndexElk();

        indexElk.addUser(USER_1, new ArrayList<>(List.of(QUERY_1_1)));
        indexElk.addUser(USER_2, new ArrayList<>(List.of()));
        indexElk.addUser(USER_3, new ArrayList<>(List.of(QUERY_3_1)));

        indexElk.addQuery(USER_1, QUERY_1_2);
        indexElk.addQuery(USER_2, QUERY_2_1);

        Map<User, List<Query>> index = indexElk.getIndex();
        assertEquals(3, index.size());
        assertTrue(index.containsKey(USER_1));
        assertTrue(index.containsKey(USER_2));
        assertTrue(index.containsKey(USER_3));

        List<Query> queriesForUser1 = index.get(USER_1);
        assertEquals(2, queriesForUser1.size());
        assertTrue(queriesForUser1.contains(QUERY_1_1));
        assertTrue(queriesForUser1.contains(QUERY_1_2));

        List<Query> queriesForUser2 = index.get(USER_2);
        assertEquals(1, queriesForUser2.size());
        assertTrue(queriesForUser2.contains(QUERY_2_1));

        List<Query> queriesForUser3 = index.get(USER_3);
        assertEquals(1, queriesForUser3.size());
        assertTrue(queriesForUser3.contains(QUERY_3_1));
    }

    @Test
    void testRemoveUser() {
        IndexElk indexElk = new IndexElk();

        indexElk.addUser(USER_1, new ArrayList<>(List.of(QUERY_1_1, QUERY_1_2)));
        indexElk.addUser(USER_2, new ArrayList<>(List.of(QUERY_2_1)));
        indexElk.addUser(USER_3, new ArrayList<>(List.of(QUERY_3_1)));

        indexElk.removeUser(USER_2);

        Map<User, List<Query>> index = indexElk.getIndex();
        assertEquals(2, index.size());
        assertTrue(index.containsKey(USER_1));
        assertTrue(index.containsKey(USER_3));

        List<Query> queriesForUser1 = index.get(USER_1);
        assertEquals(2, queriesForUser1.size());
        assertTrue(queriesForUser1.contains(QUERY_1_1));
        assertTrue(queriesForUser1.contains(QUERY_1_2));

        List<Query> queriesForUser3 = index.get(USER_3);
        assertEquals(1, queriesForUser3.size());
        assertTrue(queriesForUser3.contains(QUERY_3_1));
    }

    @Test
    void testPrintAllUsersAndQueries() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        IndexElk indexElk = new IndexElk();

        indexElk.addUser(USER_1, new ArrayList<>(List.of(QUERY_1_1, QUERY_1_2)));
        indexElk.addUser(USER_2, new ArrayList<>(List.of(QUERY_2_1)));
        indexElk.addUser(USER_3, new ArrayList<>(List.of(QUERY_3_1)));

        indexElk.printAllUsersAndQueries();

        assertEquals(ALL_USERS_INDEX_INFO, outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void testPrintUserQueriesHistory() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        IndexElk indexElk = new IndexElk();

        indexElk.addUser(USER_1, new ArrayList<>(List.of(QUERY_1_1, QUERY_1_2)));
        indexElk.addUser(USER_2, new ArrayList<>(List.of(QUERY_2_1)));
        indexElk.addUser(USER_3, new ArrayList<>(List.of(QUERY_3_1)));

        indexElk.printUserQueriesHistory(USER_1);

        assertEquals(USER_2_INDEX_INFO, outContent.toString());
        System.setOut(originalOut);
    }
}