package school.faang.BJS2_31618;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with valid data")
    void testUser_AllArgsConstructorInitializationValidData() {
        //arrange
        String name = "Anna";
        int age = 25;
        String workplace = "Amazon";
        String address = "London";

        //act
        User anna = new User(name, age, workplace, address);

        //assert
        assertEquals(name, anna.getName());
        assertEquals(age, anna.getAge());
        assertEquals(workplace, anna.getWorkplace());
        assertEquals(address, anna.getAddress());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with blank name")
    void testUser_AllArgsConstructorInitializationBlankName() {
        //arrange
        String name = "        ";
        int age = 25;
        String workplace = "Amazon";
        String address = "London";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, workplace, address));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with null name")
    void testUser_AllArgsConstructorInitializationNullName() {
        //arrange
        String name = null;
        int age = 25;
        String workplace = "Amazon";
        String address = "London";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, workplace, address));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with invalid age")
    void testUser_AllArgsConstructorInitializationInvalidAge() {
        //arrange
        String name = "Anna";
        int age = 5;
        String workplace = "Amazon";
        String address = "London";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, workplace, address));
        assertEquals("Invalid age. Must be at least 18 years old.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with invalid workplace")
    void testUser_AllArgsConstructorInitializationInvalidWorkplace() {
        //arrange
        String name = "Anna";
        int age = 25;
        String workplace = "Pyaterochka";
        String address = "London";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, workplace, address));
        assertEquals("Invalid workplace.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of User object using the AllArgs constructor with invalid address")
    void testUser_AllArgsConstructorInitializationInvalidAddress() {
        //arrange
        String name = "Anna";
        int age = 25;
        String workplace = "Amazon";
        String address = "456 Elm St";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new User(name, age, workplace, address));
        assertEquals("Invalid address.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the grouping of users by age (normal list of users)")
    void testUser_GroupUsersNormalList() {
        //arrange
        User Alice = new User("Alice", 25, "Google", "London");
        User Bob = new User("Bob", 30, "Uber", "New York");
        User Charlie = new User("Charlie", 25, "Amazon", "Amsterdam");
        User David = new User("David", 40, "Google", "New York");
        User Eve = new User("Eve", 35, "Uber", "Amsterdam");
        User Frank = new User("Frank", 30, "Amazon", "London");

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