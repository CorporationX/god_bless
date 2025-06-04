package school.faang.user_registration_bjs2_79188;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> validUsers = new ArrayList<>();
        List<Object[]> userCreations = List.of(
                new Object[]{"Alex", 17, "google", "New York"},
                new Object[]{"Alex", 18, "googlee", "New York"},
                new Object[]{"Alex", 18, "google", "NY"},
                new Object[]{null, 18, "google", "New York"},
                new Object[]{"Alex", 18, "google", "New York"}
        );

        for (int i = 0; i < userCreations.size(); i++) {
            Object[] data = userCreations.get(i);
            try {
                User user = new User(
                        (String) data[0],
                        (Integer) data[1],
                        (String) data[2],
                        (String) data[3]
                );
                validUsers.add(user);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Валидные пользователи: " + validUsers);
    }
}
