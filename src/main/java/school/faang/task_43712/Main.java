package school.faang.task_43712;

public class Main {
    public static void main(String[] args) {
        try {
            User invalidUser = new User("Bob", 16, "Amazon", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}