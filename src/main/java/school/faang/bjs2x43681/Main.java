package school.faang.bjs2x43681;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = List.of(
                    new User("Peter", 27, "Google", "New York"),
                    new User("Gomer", 45, "Uber", "Amsterdam"),
                    new User("Mohamed", 33, "Amazon", "London"),
                    new User("Jack", 32, "Amazon", "Amsterdam"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
