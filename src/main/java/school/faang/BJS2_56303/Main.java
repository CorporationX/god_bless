package school.faang.BJS2_56303;

import school.faang.BJS2_56303.User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    private static final String FOOTBALL = "Football";
    private static final String CHESS = "Chess";
    private static final String READING = "Reading";
    private static final String GAMING = "Gaming";
    private static final String COOKING = "Cooking";
    private static final String SWIMMING = "Swimming";
    private static final String PAINTING = "Painting";

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Alice", 25, new HashSet<>(Arrays.asList(FOOTBALL, CHESS, READING))),
                new User(2, "Bob", 30, new HashSet<>(Arrays.asList(GAMING, COOKING))),
                new User(3, "Charlie", 22, new HashSet<>(Arrays.asList(FOOTBALL, SWIMMING))),
                new User(4, "David", 28, new HashSet<>(Arrays.asList(PAINTING, READING)))
        );

        Set<String> activities = new HashSet<>(Arrays.asList(READING, GAMING));

        Map<User, String> result = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.printf("User: %-15s | Hobby: %-20s%n", entry.getKey().getName(), entry.getValue());
        }
    }
}