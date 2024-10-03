package school.faang.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserFieldValidationTest {
    @Test
    public void testCreateUser() {
        User user = new User("User 1", 18, "Google", "Amsterdam");
        assertEquals("User 1", user.getName(), "Name is not matching expected name");
        assertEquals(18, user.getAge(), "Age is not matching expected name");
        assertEquals("Google", user.getWorkPlace(), "Work place is not matching expected value");
        assertEquals("Amsterdam", user.getAddress(), "Address place is not matching expected value");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    public void testSetNameValidationNullEmpty(String name) {
        try {
            new User(name, 20, "Google", "Amsterdam");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null or empty", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 17, -10})
    public void testSetAgeValidationEmpty(int age) {
        try {
            new User("User 1", age, "Uber", "Amsterdam");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Age should not be less than 18", e.getMessage());
        }
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "TestWorkPlace"})
    public void testSetWorkPlaceInvalid(String workplace) {
        try {
            new User("User 1", 20, workplace, "Amsterdam");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Job is invalid. Valid jobs are: [Google, Uber, Amazon]", e.getMessage());
        }
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "TestAddress"})
    public void testSetAddressInvalid(String address) {
        try {
            new User("User 1", 20, "Amazon", address);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Address is invalid. Valid address in: [New York, Amsterdam, London]", e.getMessage());
        }
    }
}
