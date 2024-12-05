package school.faang.sprint1.bjs_43995;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Tom", 25, "Google", "London"));
        users.add(new User("Mark", 26, "Google", "London"));
        users.add(new User("Sam", 27, "Google", "London"));
        users.add(new User("Oliver", 25, "Google", "London"));
        users.add(new User("Jack", 26, "Google", "London"));
        users.add(new User("Peter", 27, "Google", "London"));

        Map<Integer, List<User>> result = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.getName());
            }
        }
    }
}
