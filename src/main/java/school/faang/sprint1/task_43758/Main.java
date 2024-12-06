package school.faang.sprint1.task_43758;

public class Main {

    public static void main(String[] args) {
        try {
            new User(null, 12, "Unknown job", "Milan");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("", 12, "Unknown job", "Milan");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("Bob", 12, "Unknown job", "Milan");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("Bob", 22, "Unknown job", "Milan");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new User("Bob", 22, "Google", "Milan");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        User user = new User("Bob", 22, "Google", "London");
        System.out.println("User created successfully: " + user);
    }
}
