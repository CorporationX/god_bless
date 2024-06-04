package faang.school.godbless;


public class Application {
    public static void main(String[] args) {
        try {
            User user = new User("Dumbledore", 120, "Google", "Amsterdam");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}