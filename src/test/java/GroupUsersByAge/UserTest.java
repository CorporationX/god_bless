package GroupUsersByAge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private List<User> userList = new ArrayList<>();
    private User user;

    //positive

    //negative

    @BeforeEach
    public void setUp(){

        userList.add(new User("Egor", 20, "Consist", "Pushkin st."));
        userList.add(new User("Mary", 19, "Freelance", "Patsaeva st."));
        userList.add(new User("Vasiliy", 50, "Zavod", "Stroiteley st."));
        userList.add(new User("Kate", 28, "Atelie", "Shenkurovo st."));

    }

    @Test
    @DisplayName("Test groupUsers()")
    public void testGroupUsers(){

        //arrange

        //act
        Map<Integer, List<User>> result = User.groupUsers(userList);

        String input = "{50=[User(name=Vasiliy, age=50, workPlace=Zavod, address=Stroiteley st.)], 19=[User(name=Mary, age=19, workPlace=Freelance, address=Patsaeva st.)]," +
                " 20=[User(name=Egor, age=20, workPlace=Consist, address=Pushkin st.)], 28=[User(name=Kate, age=28, workPlace=Atelie, address=Shenkurovo st.)]}";

        //assert
        assertEquals(input, result.toString());
    }
}
