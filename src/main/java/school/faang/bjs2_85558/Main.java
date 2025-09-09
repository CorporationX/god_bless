package school.faang.bjs2_85558;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Margaret", 39, "Google", "London");
            System.out.println(user1);
            User user2 = new User("Dan", 30, "Amazon", "Moscow");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }
}
