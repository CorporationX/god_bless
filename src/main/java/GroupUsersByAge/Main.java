package GroupUsersByAge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Egor", 20, "Uber", "London");
        User user2 = new User("Alex", 21, "Amazon", "New York");
        User user3 = new User("Mary", 19, "Google", "Amsterdam");

        List<User> users = List.of(user1, user2, user3);
        Map<Integer, List<User>> result = User.groupUsers(users);

        System.out.println(result);
    }



}
