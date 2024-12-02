package school.faang.groupedusers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Ilya", 25, "T Bank", "Msk"));
        users.add(new User("Sanya", 26, "WB", "Msk"));
        users.add(new User("Lidiya", 17, "Ozon", "Novgorod"));
        users.add(new User("Kubik", 78, "KodNod", "New York"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        List<Integer> sortedAges = new ArrayList<>(groupedUsers.keySet());
        Collections.sort(sortedAges);

        for (Integer age : sortedAges) {
            List<User> userList = groupedUsers.get(age);
            for (User user : userList) {
                System.out.println("Age: " + age
                        + ", " + user.getName()
                        + ", " + user.getWorkplace()
                        + ", " + user.getAddress());
            }
        }

    }
}
