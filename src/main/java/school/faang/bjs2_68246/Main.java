package school.faang.bjs2_68246;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = List.of(
                new User("William Clark", 30, "Amazon", "London"),
                new User("Isabella Lewis", 30, "Amazon", "Amsterdam"),
                new User("James Walker", 39, "Uber", "New York"),
                new User("Mia Young", 27, "Google", "London"),
                new User("Benjamin Hall", 39, "Google", "Amsterdam")
            );

            System.out.println(users);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
