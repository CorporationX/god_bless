package school.faang.user_registration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String[]> userData = List.of(
                new String[]{"Dmitriy", "24", "Uber", "New York"},
                new String[]{null, "24", "Uber", "New York"},
                new String[]{"  ", "25", "Amazon", "London"},
                new String[]{"Finn", "17", "FaZe", "Denmark"},
                new String[]{"Robin", "25", "Vitality", "Estonia"},
                new String[]{"Rodion", "24", "Google", "Ukraine"}
        );

        for (String[] data : userData) {
            try {
                User user = new User(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                System.out.printf("Created user with name: %s\n", user.getName());
            } catch (IllegalArgumentException validationException) {
                System.out.println("Failed to create user: " + validationException.getMessage());
            }
        }
    }
}