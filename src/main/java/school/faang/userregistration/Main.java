package school.faang.userregistration;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("", 25, "Google", "New York");
            User user2 = new User("Ilya", 16, "Google", "New York");
            User user3 = new User("Ilya", 18, "T-Bank", "New York");
            User user4 = new User("Ilya", 18, "T-Bank", "Msk");

            System.out.println("User1: " + user1.getName());
            System.out.println("User2: " + user2.getName());
            System.out.println("User3: " + user3.getName());
            System.out.println("User4: " + user4.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Miss: " + e.getMessage());
        }
    }
}
