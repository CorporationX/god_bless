package faang.school.godbless.users_by_age;

import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestUser {
    @Test
    public void testValidArguments() {
        String name = "John Doe";
        int age = 25;
        String company = "Google";
        String address = "London";

        User user = new User(name, age, company, address);

        assertEquals(name, user.getName());
        assertEquals(age, user.getAge());
        assertEquals(company, user.getCompany());
        assertEquals(address, user.getAddress());
    }

    @Test
    public void testInvalidName() {
        String name = " ";
        int age = 25;
        String company = "Acme Corp";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> {
            new User(name, age, company, address);
        });
    }
}