package faang.school.godbless.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Bob", 19, "Uber", "New York"));
        users.add(new User("Ann", 23, "Google", "London"));
        users.add(new User("Mary", 21, "Amazon", "Amsterdam"));
        users.add(new User("Ted", 28, "Vk", "Moscow"));
        Map<Integer, List<User>> group = groupUsers(users);
        System.out.println(group);
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!group.containsKey(age)) {
                group.put(age, new ArrayList<>());
            }
            group.get(age).add(user);
        }
        return group;
    }
}
