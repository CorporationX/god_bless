package groupByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            User user = new User("name " + i, (int) (1 + Math.random() * 100),
                    "manager" + i, "Chapaeva str. " + i);
            users.add(user);
        }


        for (Map.Entry<Integer, List<User>> entry : User.groupUser(users).entrySet()) {
            System.out.println("Age = " + entry.getKey() +
                    "\nValue = " + entry.getValue().toString());

        }
    }
}
