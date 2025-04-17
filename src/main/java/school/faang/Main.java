package school.faang;

import school.faang.users_by_age.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alex", 27, "Google", "London"),
                new User("Igor", 44, "Yandex", "Ufa"),
                new User("Ali", 27, "Microsoft", "Kiev"),
                new User("Tom", 44, "UFR", "Berlin")
        );
        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.printf("Возраст %s:", + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.getName());
            }
        }
    }
}