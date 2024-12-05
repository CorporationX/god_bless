package task_43954;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User(23));
        users.add(new User(53));
        users.add(new User(53));
        users.add(new User(42));
        users.add(new User(42));
        users.add(new User(42));

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.println("These users are " + entry.getKey() + " years old: " + entry.getValue());
        }
    }
}
