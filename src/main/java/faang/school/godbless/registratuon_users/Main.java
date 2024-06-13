package faang.school.godbless.registratuon_users;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Main {

    @Test
    void createValidUserTest() {
        new User("Maks", 18, "Amazon", "New York");
        new User("Kate", 25, "Google", "Amsterdam");
        new User("John", 25, "Uber", "London");
    }

    @Test
    void createNotValidUserNameTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 18, "Amazon", "New York"));
    }

    @Test
    void createNotValidUserAgeTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("Henry", 17, "Uber", "Amsterdam"));
    }

    @Test
    void createNotValidUserJobTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("Vladimir", 33, "Yandex", "Amsterdam"));
    }

    @Test
    void createNotValidUserAddressTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("Vladimir", 33, "Google", "Berlin"));
    }

    @Test
    void createNotValidAllFieldsUserTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("  ", 15, "Epam", "Warsaw"));
    }

    @Test
    void createUserWithNullParamTest(){
        assertThrows(NullPointerException.class, () -> new User(null,20, null, null));
        assertThrows(NullPointerException.class, () -> new User(null,20, "Uber", "London"));
        assertThrows(NullPointerException.class, () -> new User("Vladimir",20, null, "London"));
        assertThrows(NullPointerException.class, () -> new User("Vladimir",20, "Uber", null));
    }
}
