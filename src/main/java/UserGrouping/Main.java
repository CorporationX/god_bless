package UserGrouping;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alice", 25, "Google", "123 Main St"),
                new User("Bob", 30, "Amazon", "456 Elm St"),
                new User("Charlie", 28, "Microsoft", "789 Oak St"),
                new User("David", 35, "Tesla", "101 Pine St"),
                new User("Eve", 29, "Meta", "202 Birch St"),
                new User("Frank", 40, "IBM", "303 Cedar St"),
                new User("Grace", 32, "Apple", "404 Spruce St"),
                new User("Hank", 27, "Netflix", "505 Maple St"),
                new User("Ivy", 31, "Airbnb", "606 Walnut St"),
                new User("Jack", 26, "Twitter", "707 Willow St"),
                new User("Kevin", 25, "Google", "808 Cedar St"),
                new User("Lily", 30, "Amazon", "909 Birch St"),
                new User("Mason", 28, "Microsoft", "101 Oak St"),
                new User("Nora", 35, "Tesla", "202 Pine St")
        );
        Map<Integer, List<User>> groupedByAge = User.groupUsers(userList);
        groupedByAge.forEach((key, value) -> System.out.println(key + " " + value.toString()));
    }
}
