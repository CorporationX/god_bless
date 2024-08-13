package faang.school.godbless.java.sql.elk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ElkServiceTest {

    private ElkService elkService;
    private User userVasia;
    private List<Query> vasiaQueries;

    @BeforeEach
    void setUp() {
        this.elkService = new ElkService();
        this.userVasia = new User(1, "Vasia");
        this.vasiaQueries = new ArrayList<>();
        this.vasiaQueries.add(new Query(1, "Cat", "2024-06-07T12:50:55"));
        this.vasiaQueries.add(new Query(2, "Dog", "2024-06-05T11:50:55"));
    }

    @Test
    void testAddNewUserWithQueries_addSuccess() {
        this.elkService.addNewUserWithQueries(this.userVasia, this.vasiaQueries);
        assertEquals(1, elkService.getUserQueriesMap().size());
        assertTrue(elkService.getUserQueriesMap().containsKey(userVasia));
    }

    @Test
    void testAddNewQueryToExistingUser_addQueryToExistingUser() {
        Query newQuery = new Query(4, "Monkey");
        this.elkService.addNewUserWithQueries(this.userVasia, this.vasiaQueries);
        this.elkService.addNewQueryToExistingUser(this.userVasia, newQuery);
        assertTrue(elkService.getUserQueriesMap().containsKey(this.userVasia));
        assertEquals(3, elkService.getUserQueriesMap().get(this.userVasia).size());
    }

    @Test
    void testAddNewQueryToExistingUser_addQueryToNonExistingUser() {
        Query newQuery = new Query(3, "Monkey");
        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            this.elkService.addNewQueryToExistingUser(this.userVasia, newQuery);
        });
        assertEquals(Constants.USER_NOT_FOUND, ex.getMessage());
    }

    @Test
    void testDeleteUser_deleteExistingUser() {
        this.elkService.addNewUserWithQueries(this.userVasia, this.vasiaQueries);
        assertTrue(elkService.getUserQueriesMap().containsKey(this.userVasia));
        this.elkService.deleteUser(this.userVasia);
        assertFalse(elkService.getUserQueriesMap().containsKey(userVasia));
    }

    @Test
    void testDeleteUser_deleteNonExistingUser() {
        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            this.elkService.deleteUser(this.userVasia);
        });
        assertEquals(Constants.USER_NOT_FOUND, ex.getMessage());
    }

    @Test
    void showUserQueryHistory_showQueriesForExistingUser() {
        this.elkService.addNewUserWithQueries(this.userVasia, this.vasiaQueries);
        assertDoesNotThrow(() -> {
            this.elkService.showUserQueryHistory(this.userVasia);
        });
    }

    @Test
    void showUserQueryHistory_showQueriesForNonExistingUser() {
        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            this.elkService.showUserQueryHistory(this.userVasia);
        });
        assertEquals(Constants.USER_NOT_FOUND, ex.getMessage());
    }
}