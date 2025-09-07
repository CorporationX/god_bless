package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            new User("lily", 36, "Google", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed: " + e.getMessage());
        }
    }
}
