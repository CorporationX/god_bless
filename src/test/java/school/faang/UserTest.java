package school.faang;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void groupUsers_shouldReturnGroupedUsersByAge(){
        // given
        List<User> users = List.of(
                new User("Max", 30, "Amazon", "Amsterdam"),
                new User("John", 32, "Google", "Amsterdam"),
                new User("Eric", 32, "Google", "London"),
                new User("Anna", 30, "Amazon", "New York"),
                new User("Mia", 30, "Uber", "London"));

        // when
        Map<Integer, List<User>> expected = new HashMap<>();
        expected.put(30, List.of(
                new User("Max", 30, "Amazon", "Amsterdam"),
                new User("Anna", 30, "Amazon", "New York"),
                new User("Mia", 30, "Uber", "London")
        ));

        expected.put(32, List.of(
                new User("John", 32, "Google", "Amsterdam"),
                new User("Eric", 32, "Google", "London")
        ));

        // then
        assertThat(expected).isEqualTo(User.groupUsers(users));
    }

    @Test
    void groupUsers_shouldReturnIllegalArgumentException_whenAgeIsLessThanEighteen(){
        try {
            new User("Max", 17, "Amazon", "London");
        } catch(IllegalArgumentException exception){
            assertThat(exception.getMessage()).isEqualTo("Age is less than 18");
        }
    }

    @Test
    void groupUsers_shouldReturnIllegalArgumentException_whenNameIsEmpty(){
        try {
            new User("", 23, "Amazon", "London");
        } catch(IllegalArgumentException exception){
            assertThat(exception.getMessage()).isEqualTo("Name is empty");
        }
    }

    @Test
    void groupUsers_shouldReturnIllegalArgumentException_whenWorkPlaceNotExist(){
        try {
            new User("Max", 34, "Netflix", "London");
        } catch(IllegalArgumentException exception){
            assertThat(exception.getMessage()).isEqualTo("Work place does not exist");
        }
    }

    @Test
    void groupUsers_shouldReturnIllegalArgumentException_whenAddressNotExist(){
        try {
            new User("John", 18, "Amazon", "Manila");
        } catch(IllegalArgumentException exception){
            assertThat(exception.getMessage()).isEqualTo("Address does not exist");
        }
    }

}