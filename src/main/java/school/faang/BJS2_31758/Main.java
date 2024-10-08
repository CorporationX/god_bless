package school.faang.BJS2_31758;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> activities = new HashSet<>(Arrays.asList("swimming", "cycling"));

        try {
            User user1 = new User(1, "Bob" , 34, activities, "Google", "London");
            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create user: " + e.getMessage());
        }

        try {
            User user2 = new User(2, "Patrik", 34, activities, "Apple", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create user: " + e.getMessage());
        }
    }
}
