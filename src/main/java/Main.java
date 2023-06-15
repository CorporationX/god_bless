import faang.school.godbless.groupUsers.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User("John", 23, "Amazon", "New York");
        User user2 = new User("Alice", 30, "Uber", "Washington");
        User user3 = new User("Bred", 23, "Apple", "Los Angeles");
        User user4 = new User("Aron", 18, "Meta", "New York");
        User user5 = new User("Justin", 30, "Google", "Los Angeles");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Map<Integer, List<User>> resultGroupsMap = User.groupUsersByAge(users);
        System.out.println(resultGroupsMap);
    }
}
