package faang.school.godbless.groupUsers;

public class Main {

    public static void main(String[] args) {
        try {
            User user = new User("Максим", 25, "Google", "London");
            System.out.println("User1 created successfully: " + user);
            System.out.println("--------------");
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create user: " + e.getMessage());
        }

        try {
            User user = new User("Максим", 17, "Google", "London");
            System.out.println("User created successfully: " + user);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create user2: " + e.getMessage());
        }
    }
}
