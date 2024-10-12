package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("John",22,"Bells","Google");
        User secondUser = new User("John",22,"Bells","Google");
        User thirdUser = new User("John",22,"Bells","Google");
        User fourthUser = new User("John",22,"Bells","Google");

        List<User> users = new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        users.add(fourthUser);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);


        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " -> Users: " + entry.getValue());
        }
    }
}
