package school.faang.task_43700;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Alice", 25, "Google", "London");
            System.out.println(user1);

            User user2 = new User("Bob", 17, "Uber", "New York");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }

        try {
            User user3 = new User("Charlie", 30, "Apple", "Amsterdam");
            System.out.println(user3);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }
}
