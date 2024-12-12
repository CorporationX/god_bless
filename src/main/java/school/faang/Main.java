package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("John", 20, "Google", "London");
            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user2 = new User("Jack", 17, "Facebook", "Moscow");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
