package group_users_age_BJS2_31398;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ben", 30, "SAP", "Frankfurt"));
        users.add(new User("Cyril", 30, "ADP", "NewYork"));
        users.add(new User("Roben", 27, "BMW", "Munich"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
