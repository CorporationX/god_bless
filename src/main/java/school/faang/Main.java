package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(20, "Alice", "TechSolutions", "123 Maple Street"),
                new User(35, "Bob", "GreenField Corp", "456 Oak Avenue"),
                new User(20, "Charlie", "BlueWave Ltd", "789 Pine Road"),
                new User(35, "Diana", "Horizon Inc", "321 Cedar Lane"),
                new User(20, "Ethan", "StarTech", "654 Birch Boulevard"),
                new User(30, "Fiona", "Quantum Systems", "987 Spruce Drive")
        );

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        System.out.println(grouped);
    }
}