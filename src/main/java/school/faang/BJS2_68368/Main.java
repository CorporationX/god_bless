package school.faang.BJS2_68368;

public class Main {
    public static void main(String[] args) {
        User user = new User("Robin", 22, "Google", "London");
        System.out.println(user.toString());

        try {
            User user1 = new User("Robin", 17, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user2 = new User("Robin", 22, "Samokat", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user2 = new User("Robin", 22, "Google", "Melburn");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
