package the_elk_query_index;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final User USER = new User(1, "Jane");
    @BeforeEach
    void setUp() {
        Main.addUser(USER, List.of(new Query(1, "Hello World", 12345678)));
    }

    @AfterEach
    void tearDown() {
        Main.USER_QUERIES.clear();
    }

    @Test
    void addUser() {
        Main.addUser(new User(1, "John"), List.of(new Query(1, "Hello World", 123456789)));
        assertEquals(2, Main.USER_QUERIES.size());

        assertEquals(new User(1, "Jane"), Main.USER_QUERIES.keySet().iterator().next());
    }

    @Test
    void addQuery() {
        Main.addQuery(USER, new Query(2, "How are you?", 98765321));
        assertEquals(2, Main.USER_QUERIES.get(USER).size());
        assertEquals(new Query(2, "How are you?", 98765321), Main.USER_QUERIES.get(USER).get(1));
    }

    @Test
    void removeUser() {
        Main.removeUser(USER);
        assertEquals(0, Main.USER_QUERIES.size());
    }

    @Test
    void printUsersQueries() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.printUsersQueries();

        assertEquals(
                "Jane:\n" +
                        "  1 Hello World 12345678\n",
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}