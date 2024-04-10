package faang.school.godbless.Task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.Task_2.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Vadim", 18, "Google", "London");
        User user2 = new User("Mike", 88, "Uber", "New - York");
        User user3 = new User("Jessica", 29, "Amazon", "London");
        User user4 = new User("Danny", 44, "Google", "New - York");
        User user5 = new User("Clare", 29, "Amazon", "Amsterdam");
        User user6 = new User("Vadim", 29, "Amazon", "Amsterdam");

        List<User> list = new ArrayList<>();

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);


        Map<Integer, List<User>> map = groupUsers(list);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<User> listOfUsers = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + listOfUsers.toString());
        }
    }
}
