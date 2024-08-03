package user.group;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Petya", 18, "Somewhere", "Elsewhere"),
                new User("Vasya", 20, "Somewhere", "Elsewhere"),
                new User("Katya", 19, "Somewhere", "Elsewhere"),
                new User("Dimas", 19, "Somewhere", "Elsewhere"),
                new User("Vika", 20, "Somewhere", "Elsewhere")
        );
        System.out.println("Users");
        for (User user : users) {
            System.out.println(user);
        }

        var ageMap = User.groupUsers(users);
        System.out.println("Age map:");
        for (Map.Entry<Integer, List<User>> entry : ageMap.entrySet()) {
            System.out.println("Age " + entry.getKey() + ":");
            for(User user : entry.getValue()) {
                System.out.println("    " + user);
            }
        }
    }
}
