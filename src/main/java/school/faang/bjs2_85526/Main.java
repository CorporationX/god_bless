package school.faang.bjs2_85526;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Julie", 40, "Company A", "Stockholm"));
        users.add(new User("Bonnie", 30, "Company B", "La Paz"));
        users.add(new User("Judith", 40, "Company C", "Buenos Aires"));
        users.add(new User("Jeffery", 20, "Company D", "Chicago"));
        users.add(new User("Rita", 30, "Company E", "Moscow"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" - Name: " + user.getName() + ", Address workplace: ");
            }
        }
    }
}
