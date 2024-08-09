package faang.school.godbless.BJS2_18484;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Arman", 17, "Google", "New York");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating User: " + e.getMessage());
        }
    }
}
