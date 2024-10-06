package dima.evseenko.query;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QueryServiceTest {

    @Test
    void addQuery() {
        User dima = new User(1L, "Dima");

        QueryService qs = new QueryService();
        qs.addQuery(dima, new Query(1L, "query1..."));

        assertTrue(qs.getQueries(dima).contains(new Query(1L, "query1...")));
    }

    @Test
    void addQueries() {
        User dima = new User(1L, "Dima");

        QueryService qs = new QueryService();
        qs.addQueries(dima, getQueries1());

        assertTrue(qs.getQueries(dima).contains(new Query(1L, "query1...")));
        assertTrue(qs.getQueries(dima).contains(new Query(2L, "query2...")));
        assertTrue(qs.getQueries(dima).contains(new Query(3L, "query3...")));
    }

    @Test
    void deleteQuery() {
        User dima = new User(1L, "Dima");

        QueryService qs = new QueryService();
        qs.addQueries(dima, getQueries1());
        qs.deleteQuery(dima, new Query(1L, "query1..."));

        assertFalse(qs.getQueries(dima).contains(new Query(1L, "query1...")));
    }

    @Test
    void deleteQueries() {
        User dima = new User(1L, "Dima");

        QueryService qs = new QueryService();
        qs.addQueries(dima, getQueries1());
        qs.deleteQueries(dima, getQueries1());

        assertEquals(0, qs.getQueries(dima).size());
    }

    @Test
    void deleteUser() {
        User dima = new User(1L, "Dima");

        QueryService qs = new QueryService();
        qs.addQueries(dima, getQueries1());
        qs.deleteUser(dima);

        assertNull(qs.getQueries(dima));
    }

    @Test
    void getQueries() {
        User dima = new User(1L, "Dima");

        QueryService qs = new QueryService();
        qs.addQueries(dima, getQueries1());

        assertNotNull(qs.getQueries(dima));
    }

    @Test
    void getQueriesInvalidUser() {
        assertNull(new QueryService().getQueries(null));
        assertNull(new QueryService().getQueries(new User(1L, "Dima")));
    }

    private List<Query> getQueries1() {
        return List.of(
                new Query(1L, "query1..."),
                new Query(2L, "query2..."),
                new Query(3L, "query3...")
        );
    }
}