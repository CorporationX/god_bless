package faang.school.godbless.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Bob", 19, "Uber", "New York"));
        users.add(new User("Ann", 23, "Google", "London"));
        users.add(new User("Mary", 21, "Amazon", "Amsterdam"));
        users.add(new User("Ted", 28, "Vk", "Moscow"));
        Map<Integer, List<User>> group = User.groupUsers(users);
        System.out.println(group);
    }
}
