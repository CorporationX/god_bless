package grouping_users_by_age;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static grouping_users_by_age.Users.groupUsers;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void groupUsers_testReturnEmptyMap(){
        var result = groupUsers(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void groupUsers_testReturnEmptyMapIfListIsEmpty(){
        var result = groupUsers(Collections.emptyList());
        assertEquals(0,result.size());
    }
    @Test
    void groupUsers_testReturnCorrectMap(){
        List<Users> users = List.of(
                new Users("Max", 17, "sber", "Isa"),
                new Users("Fedor", 17, "tinkoff", "Novosib"),
                new Users("Eugen", 69, "sber", "Novosib")
        );
        var result = groupUsers(users);

        assertEquals(2,result.size());
        assertEquals(2,result.get(17).size());
    }
}