package faang.school.godbless.registrationOfUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Bill", 35, "Uber", "London");
        User user2 = new User("Dan", 45, "Uber", "New York");
        User user3 = new User("Lola", 45, "Google", "London");
        User user4 = new User("Max", 35, "Amazon", "Amsterdam");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        Map<Integer, List<User>> map = User.groupUsers(list);

        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println("Age of User: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}