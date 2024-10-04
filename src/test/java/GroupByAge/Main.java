package GroupByAge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {



        List<User> users = Arrays.asList(
                new User("olya", 24, "Uber","London"),
                new User("kolya", 22, "Uber", "London"),
                new User("molya", 25, "Uber", "London"),
                new User("tolya", 24, "Uber", "London"));

        User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("Age" + entry.getKey() + "user" + entry.getValue());
        }
    }
}
