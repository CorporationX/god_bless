package Task2;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Vasya", 23, "  ", "efs");
        User user2 = new User("Vanya", 9, "  ", "efs");
        User user3 = new User("Nikita", 23, "  ", "efs");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Map<Integer, ArrayList<User>> usersGroupedByAge = User.groupUsers(users);

        System.out.println(usersGroupedByAge);
    }
}
