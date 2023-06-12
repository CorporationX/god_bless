import faang.school.godbless.classes.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUser {
    private final String POSITIVE = "Positive: ";
    private final String NEGATIVE = "Negative :";
    //Positive
    @Test
    @DisplayName(POSITIVE + "create User with 18 and greater age")
    public void createUserWith18AndGreaterAge(){
        Assertions.assertNotNull(new User("Rustam", 18, "Amazon", "New York"));
        Assertions.assertNotNull(new User("Rustam", 19, "Amazon", "New York"));
    }

    @Test
    @DisplayName(POSITIVE + "create User with any name")
    public void createUserWithName(){
        Assertions.assertNotNull(new User("Rustam", 18, "Amazon", "New York"));
        Assertions.assertNotNull(new User("D", 19, "Amazon", "New York"));
    }

    @Test
    @DisplayName(POSITIVE + "create User with valid jobs")
    public void createUserWithValidJobs(){
        Assertions.assertNotNull(new User("Rustam", 18, "Amazon", "New York"));
        Assertions.assertNotNull(new User("Rustam", 19, "Uber", "New York"));
        Assertions.assertNotNull(new User("Rustam", 19, "Google", "New York"));
    }

    @Test
    @DisplayName(POSITIVE + "create User with valid locations")
    public void createUserWithValidLocations(){
        Assertions.assertNotNull(new User("Rustam", 18, "Amazon", "New York"));
        Assertions.assertNotNull(new User("Rustam", 19, "Uber", "Amsterdam"));
        Assertions.assertNotNull(new User("Rustam", 19, "Google", "London"));
    }

    //Negative
    @Test
    @DisplayName(NEGATIVE + "Create User with 17 and less age")
    public void createUserWith17AndLessAge(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("Rustam", 17, "Amazon", "New York");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("Rustam", 16, "Amazon", "New York");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("Rustam", 10, "Amazon", "New York");
        });
    }

    @Test
    @DisplayName(NEGATIVE + "Create User with empty name")
    public void createUserWithEmptyName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("",18 , "Amazon", "New York");
        });
    }

    @Test
    @DisplayName(NEGATIVE + "Create User without name")
    public void createUserWithoutName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(null, 18, "Amazon", "New York");
        });
    }

    @Test
    @DisplayName(NEGATIVE + "Create User with invalid job")
    public void createUserWithInvalidJob(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("",18 , "Magnit", "New York");
        });
    }

    @Test
    @DisplayName(NEGATIVE + "Create User invalid location")
    public void createUserWithInvalidLocation(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("",18 , "Amazon", "Novosibirsk");
        }, "Why");
    }

}
