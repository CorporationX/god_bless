package faang.school.godbless.queryIndex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private User alexey;
    private Query alexeyQuery1;
    private Query alexeyQuery2;
    private Query alexeyQuery3;
    private Query alexeyQuery4;
    private User victor;
    private Query victorQuery1;
    private Query victorQuery2;

    @BeforeEach
    void setUp() {
        main = new Main();
        alexey = new User(1, "Алексей");
        alexeyQuery1 = new Query(1, "Запрос 1", LocalDateTime.now());
        alexeyQuery2 = new Query(2, "Запрос 2", LocalDateTime.of(2024, 7, 17, 23, 54));
        alexeyQuery3 = new Query(3, "Запрос 3", LocalDateTime.of(2024, 7, 16, 22, 54));
        alexeyQuery4 = new Query(4, "Запрос 4", LocalDateTime.of(2024, 7, 16, 23, 54));
        victor = new User(2, "Виктор");
        victorQuery1 = new Query(1, "Запрос 1", LocalDateTime.of(2024, 8, 7, 23, 54));
        victorQuery2 = new Query(2, "Запрос 2", LocalDateTime.of(2021, 7, 31, 23, 44));
    }

    @Test
    void testAddNewUserWithQueries() {
        main.addNewUserWithQueries(alexey, new ArrayList<>(List.of(alexeyQuery1, alexeyQuery2, alexeyQuery3)));
        assertEquals(1, main.getListOfUserQueries().size());
        main.addNewUserWithQueries(victor, new ArrayList<>(List.of(victorQuery1, victorQuery2)));
        assertEquals(2, main.getListOfUserQueries().size());
        assertTrue(main.getListOfUserQueries().containsKey(alexey));
        assertTrue(main.getListOfUserQueries().containsKey(victor));
    }

    @Test
    void testAddNewQuery() {
        main.addNewUserWithQueries(alexey, new ArrayList<>(List.of(alexeyQuery1, alexeyQuery2, alexeyQuery3)));
        main.addNewQuery(alexey, alexeyQuery4);
        assertEquals(4, main.getListOfUserQueries().get(alexey).size());
    }

    @Test
    void testAddNewQueryWhenUserIsNotFound() {
        assertThrows(IllegalArgumentException.class, () -> main.addNewQuery(alexey, alexeyQuery4));
    }

    @Test
    void testRemoveUser() {
        main.addNewUserWithQueries(alexey, new ArrayList<>(List.of(alexeyQuery1, alexeyQuery2, alexeyQuery3)));
        main.addNewUserWithQueries(victor, new ArrayList<>(List.of(victorQuery1, victorQuery2)));
        main.removeUser(alexey);
        assertFalse(main.getListOfUserQueries().containsKey(alexey));
    }

    @Test
    void testIsSortedList() {
        main.addNewUserWithQueries(alexey, new ArrayList<>(List.of(alexeyQuery1, alexeyQuery2, alexeyQuery3)));
        main.addNewQuery(alexey, alexeyQuery4);
        List<Query> queries = main.getListOfUserQueries().get(alexey);
        assertTrue(queries.get(0).getTIMESTAMP().isBefore(queries.get(1).getTIMESTAMP()));
        assertTrue(queries.get(1).getTIMESTAMP().isBefore(queries.get(2).getTIMESTAMP()));
        assertTrue(queries.get(2).getTIMESTAMP().isBefore(queries.get(3).getTIMESTAMP()));
    }


    @Test
    void printAllUsersWithQueries() {
        main.addNewUserWithQueries(alexey, new ArrayList<>(List.of(alexeyQuery1, alexeyQuery2, alexeyQuery3)));
        main.addNewUserWithQueries(victor, new ArrayList<>(List.of(victorQuery1, victorQuery2)));
        main.allUsersWithQueries();
    }

    @Test
    void printUserQueries() {
        main.addNewUserWithQueries(alexey, new ArrayList<>(List.of(alexeyQuery1, alexeyQuery2, alexeyQuery3)));
        main.addNewUserWithQueries(victor, new ArrayList<>(List.of(victorQuery1, victorQuery2)));
        main.userQueries(victor);
    }


}