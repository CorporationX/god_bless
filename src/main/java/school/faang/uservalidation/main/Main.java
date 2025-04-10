package school.faang.uservalidation.main;

import school.faang.uservalidation.entity.User;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Linda", 18, "Google", "London");
            System.out.println("User created: " + user);
            User user1 = new User("", 18, "Google", "London");
            System.out.println("User created: " + user1);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create user: " + e.getMessage());
        }
    }
}
