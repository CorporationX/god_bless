package Registration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        List<User> users = new ArrayList<>();

        User user1 = new User("Vlad", 24, "Uber", "Amsterdam");
        users.add(user1);
        User user2 = new User("Nick", 22, "Google", "New York");
        users.add(user2);
        User user3 = new User("Paul", 22, "Uber", "Amsterdam");
        users.add(user3);
        User user4 = new User("Stas", 19, "Amazon", "London");
        users.add(user4);


        for (Map.Entry<Integer, List<User>> entry : User.groupUser(users).entrySet()) {
            System.out.println("Age = " + entry.getKey() +
                    "\nValue = " + entry.getValue().toString());

        }
    }
}
