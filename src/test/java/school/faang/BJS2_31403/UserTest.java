package school.faang.BJS2_31403;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor")
    void testUser_AllArgsConstructorInitialization() {
        //arrange
        String name = "Anna";
        int age = 25;
        String workplace = "Amazon";
        String address = "456 Elm St";

        //act
        User anna = new User(name, age, workplace, address);

        //assert
        assertEquals(name, anna.getName());
        assertEquals(age, anna.getAge());
        assertEquals(workplace, anna.getWorkplace());
        assertEquals(address, anna.getAddress());
    }

    @Test
    @DisplayName("Testing the grouping of users by age (normal list of users)")
    void testUser_GroupUsersNormalList() {
        //arrange
        User Alice = new User("Alice", 25, "Company A", "123 Main St");
        User Bob = new User("Bob", 30, "Company B", "456 Elm St");
        User Charlie = new User("Charlie", 25, "Company C", "789 Oak St");
        User David = new User("David", 40, "Company D", "101 Pine St");
        User Eve = new User("Eve", 35, "Company E", "202 Cedar St");
        User Frank = new User("Frank", 30, "Company F", "303 Maple St");

        List<User> users = new ArrayList<>(List.of(Alice, Bob, Charlie, David, Eve, Frank));

        //act
        Map<Integer, List<User>> ageUsersPairs = User.groupUsers(users);

        //assert
        assertEquals(4, ageUsersPairs.size());
        assertTrue(ageUsersPairs.get(25).contains(Alice));
        assertTrue(ageUsersPairs.get(25).contains(Charlie));
        assertTrue(ageUsersPairs.get(30).contains(Bob));
        assertTrue(ageUsersPairs.get(30).contains(Frank));
        assertTrue(ageUsersPairs.get(35).contains(Eve));
        assertTrue(ageUsersPairs.get(40).contains(David));
    }

    @Test
    @DisplayName("Testing the grouping of users by age (empty list of users)")
    void testUser_GroupUsersEmptyList() {
        //arrange
        List<User> users = new ArrayList<>();

        //act
        Map<Integer, List<User>> ageUsersPairs = User.groupUsers(users);

        //assert
        assertEquals(0, ageUsersPairs.size());
    }

    @Test
    @DisplayName("Testing the grouping of users by age (null list of users)")
    void testUser_GroupUsersNullList() {
        //assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> User.groupUsers(null));
        assertEquals("Given users list was null", exception.getMessage());
    }
}