package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    private static final List<User> users = new ArrayList<>();

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), initWith -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void main(String[] args) {
        users.add(new User("Ann", 30, "MoscowCity", "Moscow"));
        users.add(new User("John", 25, "Manhatten", "New York"));
        users.add(new User("Joshua", 28, "Telaviv", "Israel, Telaviv 20"));
        users.add(new User("Annete", 31, "Paris", "France, Paris, Elisey fields"));
        users.add(new User("Franchesko", 25, "Madrid", "Spain, Madrid, Some Street"));
        users.add(new User("Alexey", 25, "Zenit", "Russia, St.Petersburg"));
        users.add(new User("Vladimir", 71, "Kremlin", "Russia, Moscow"));
        users.add(new User("Robert", 30, "London", "Great Britain, London"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        System.out.println("Users grouped by age: " + groupedUsers);
    }
}
