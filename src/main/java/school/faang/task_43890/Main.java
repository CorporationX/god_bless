package school.faang.task_43890;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.task_43890.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Misha",28, "Google","New York"));
        users.add(new User("Denis", 28, "Yandex", "Moskow"));
        users.add(new User("Oleg", 23, "Uber", "London"));
        users.add(new User("Stas", 23, "Amazon", "Amsterdam"));
        users.add(new User("Nikita", 23, "Microsoft", "Redmond"));
        users.add(new User("Oksana", 25, "Intell", "Santa-Clara"));
        users.add(new User("Alexander", 25, "Renault", "Paris"));
        users.add(new User("Olga", 26, "Euronews", "Paris"));
        Map<Integer, List<User>> groupUsers = groupUsers(users);
        printAll(groupUsers);
    }

    public static void printAll(Map<Integer, List<User>> groupUsers) {
        groupUsers.forEach((key, users) -> {
            System.out.println("Age: " + key);
            users.forEach(System.out::println);
        });
    }
}
