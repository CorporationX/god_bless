package faang.school.godbless.javaCore.groupUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> group = groupUsers(createUsers());

        group.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    private static List<User> createUsers() {
        return List.of(
                new User("John", 32, "Amazon", "New-York"),
                new User("Erick", 32, "Google", "London"),
                new User("Bred", 31, "Amazon", "New-York"),
                new User("John", 31, "Google", "London"),
                new User("Seth", 30, "Amazon", "New-York"),
                new User("Palmer", 30, "Google", "London"),
                new User("Eddy", 35, "Uber", "London"),
                new User("Christopher", 35, "Google", "Amsterdam"),
                new User("Kenny", 28, "Amazon", "Amsterdam"),
                new User("Collin", 28, "Uber", "Amsterdam")
        );
    }

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapGroupUsers = new HashMap<>();
        for (User u : users) {
            List<User> listUsersByAge = new ArrayList<>();
            int age = u.getAge();
            for (User us : users) {
                int ageAnotherUser = us.getAge();
                if (age == ageAnotherUser) {
                    listUsersByAge.add(us);
                }
            }
            mapGroupUsers.put(age, listUsersByAge);
        }
        return mapGroupUsers;
    }
}
