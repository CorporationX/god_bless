package school.faang.bjs2_85620;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Kamil", 22, "Address1", "Work1"));
        users.add(new User("Tair", 12, "Address1", "School"));
        users.add(new User("Asya", 15, "Address1", "School"));
        users.add(new User("Elena", 48, "Address1", "Work2"));
        users.add(new User("Albert", 48, "Address1", "Work3"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Integer age : grouped.keySet()) {
            System.out.println("Age " + age + ":");
            for (User user : grouped.get(age)) {
                System.out.println(" - " + user.getName());
            }
        }
    }
}