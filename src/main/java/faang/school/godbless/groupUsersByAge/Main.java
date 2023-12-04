package faang.school.godbless.groupUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, List<User>> group = User.groupUsers(createUsers());

        for (Map.Entry<Integer, List<User>> entry : group.entrySet()) {
            Integer key = entry.getKey();
            List<User> users = entry.getValue();

            System.out.print(key + " - ");
            StringBuilder usersName = new StringBuilder();
            for (User user : users) {
                usersName.append(user.getName()).append(" ");
            }
            System.out.println(usersName.toString().trim());
        }
    }
    private static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 32, "Amazon", "New-York"));
        users.add(new User("Erick", 32, "Facebook", "Los-Angeles"));

        users.add(new User("Bred", 31, "Amazon", "New-York"));
        users.add(new User("John", 31, "Facebook", "Los-Angeles"));

        users.add(new User("Seth", 30, "Amazon", "New-York"));
        users.add(new User("Palmer", 30, "Facebook", "Las-Vegas"));

        users.add(new User("Eddy", 35, "Amazon", "Las-Vegas"));
        users.add(new User("Christopher", 35, "Facebook", "Los-Angeles"));

        users.add(new User("Kenny", 28, "Amazon", "Las-Vegas"));
        users.add(new User("Collin", 28, "Facebook", "Las-Vegas"));

        return users;
    }
}
