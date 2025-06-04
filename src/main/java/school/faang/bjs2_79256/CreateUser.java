package school.faang.bjs2_79256;

public class CreateUser {
    public static void main(String[] args) {
        try {
            User user1 = new User("Mary", 25, "Google", "Amsterdam");
            System.out.println(user1);
            User user2 = new User("Nicholas", 24, "Apple", "London");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception " + e);
        }
    }
}
