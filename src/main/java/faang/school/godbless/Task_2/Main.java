package faang.school.godbless.Task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.Task_2.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User("Vadim", 18, "Google", "London");
        User user2 = new User("Mike", 88, "Uber", "New - York");
        User user3 = new User("Jessica", 29, "Amazon", "London");
        User user4 = new User("Danny", 44, "Google", "New - York");
        User user5 = new User("Clare", 29, "Amazon", "Amsterdam");
        User user6 = new User("Vadim", 29, "Amazon", "Amsterdam");


        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        Map<Integer, List<User>> map = groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<User> listOfUsers = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + listOfUsers.toString());
        }
    }
}
