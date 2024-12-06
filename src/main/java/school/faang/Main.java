package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Dias", 25, "Google", "London");
            System.out.println(user1);

            User user2 = new User("Arman", 11, "Microsoft", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
