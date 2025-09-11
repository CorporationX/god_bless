package school.faang.bjs2_85669;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        Object[][] inputData = {
                {"Kamil", 22, "Google", "London"},
                {"Tair", 17, "Uber", "New York"},
                {"Elena", 30, "VRT", "London"},
                {"Asya", 25, "Amazon", "Amsterdam"},
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
                System.out.printf("%s: %s%n", data[0], e.getMessage());
            }
        }

        System.out.println("\nSelected people:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}