package faang.school.godbless.reverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("George", 19, "Google", "Amsterdam");
        User user2 = new User("Gennady", 40, "Uber", "Amsterdam");
        User user3 = new User("Elizabeth", 24, "Amazon", "London");

        List<User> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Map<Integer, List<User>> sortedByAge = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : sortedByAge.entrySet()) {
            System.out.println("Users with age " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println(user.getName() + ", " + user.getWorkplace() + ", " + user.getAddress());
            }
            System.out.println();
        }
    }


}
