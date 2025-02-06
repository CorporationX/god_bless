package userRegistration;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Alice", 28, "Google", "London");
            System.out.println("Valid user created: " + validUser.toString());
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating valid user: " + e.getMessage());
        }

        try {
            User invalidUser = new User("Bob", 30, "Facebook", "New York");
            System.out.println("Invalid user created: " + invalidUser.toString());
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating invalid user: " + e.getMessage());
        }
    }
}
