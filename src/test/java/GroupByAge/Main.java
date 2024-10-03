package GroupByAge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        User olya = new User("olya", 24, "Uber", "London");
        User kolya = new User("kolya", 22, "Uber", "London");
        User molya = new User("molya", 25, "Uber", "London");
        User tolya = new User("tolya", 24, "Uber", "London");

        List<User> users = Arrays.asList(olya, kolya, tolya, molya);
        User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("Age" + entry.getKey() + "user" + entry.getValue());
        }
    }
}
