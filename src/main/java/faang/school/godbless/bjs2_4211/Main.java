package faang.school.godbless.bjs2_4211;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Ivanov", 28, "Google", "New York"));
        users.add(new User("Petrov", 28, "Uber", "Amsterdam"));
        users.add(new User("Sidorov", 38, "Amazon", "London"));
        users.add(new User("Limonov", 38, "Uber", "Amsterdam"));
        users.add(new User("Scott", 21, "Google", "New York"));

        Map<Integer, List<User>> userGroups = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : userGroups.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
