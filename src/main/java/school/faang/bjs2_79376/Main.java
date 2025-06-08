package school.faang.bjs2_79376;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("John", 24, "Google", "London");
            User user2 = new User("Anna", 30, "Microsoft", "New York");
            User user3 = new User("John", 17, "Google", "London");
            User user4 = new User("John", 25, "Google", "Madagaskar");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
