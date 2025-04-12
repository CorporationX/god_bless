package school.faang.BJS2_69079;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("John", 26, "Google", "Sidney");
        User secondUser = new User("Amanda", 33, "NASA", "Washington");
        User thirdUser = new User("Harry", 26, "Kingsman", "London");
        User fourthUser = new User("Bob", 43, "Bayer", "Frankfurt");

        List<User> users = List.of(firstUser, secondUser, thirdUser, fourthUser);
        Map<Integer, ArrayList<User>> mappedUsers = User.groupUsers(users);
    }
}
