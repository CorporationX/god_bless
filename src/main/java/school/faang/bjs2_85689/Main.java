package school.faang.bjs2_85689;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        Object[][] inputData = {
                {"Zina", 32, "Google", "London"},
                {"Amir", 25, "Uber", "New York"},
                {"Katya", 35, "VRT", "London"},
                {"Egor", 29, "Amazon", "Amsterdam"},
                {"", 30, "Google", "London"},
                {"Alex", 24, "Microsoft", "New York"},
                {"Anna", 37, "Uber", "Miami"},
                {"Anna", 17, "Amazon", "Amsterdam"},
        };

        for (Object[] data : inputData) {
            try {
                User user = new User(
                        (String) data[0],
                        (int) data[1],
                        (String) data[2],
                        (String) data[3]
                );
                users.add(user);
            } catch (IllegalArgumentException e) {
                System.out.println(data[0] + ": " + e.getMessage());
            }
        }

        System.out.println("\nSelected people:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
