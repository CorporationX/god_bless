package school.faang.task44028;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<User> users = new ArrayList<>();

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