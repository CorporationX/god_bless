package group.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static group.users.User.groupUsers;
import static group.users.User.printResult;

public class Main {

    private static void addUser(List<User> users, String name, int age, String workplace, String addres) {
        try {
            users.add(new User(name, age, workplace, addres));
        } catch (IllegalArgumentException | IllegalAccessException exception) {
            System.out.println("\n" + exception.getMessage() + "\n");
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        List<User> users = new ArrayList<>();
        addUser(users, "Ivan", 19, "Uber", "New York");
        addUser(users, "Pavel", 22, "Amazon", "London");
        addUser(users, "Anton", 18, "Google", "Amsterdam");
        addUser(users, "Viktor", 20, "Uber", "London");
        addUser(users, "Jane", 25, "Amazon", "Amsterdam");
        addUser(users, "Kate", 30, "Google", "New York");
        addUser(users, "Vlad", 27, "Uber", "Amsterdam");

        Map<Integer, List<User>> grouped = groupUsers(users);
        groupUsers(users);
        printResult(grouped);
    }
}
