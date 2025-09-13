package school.faang.registration;

public class Main {
    @SuppressWarnings("checkstyle:CommentsIndentation")

    public static void main(String[] args) {
        try {
            User user = new User("Rusya", 21, "Google", "London");
            User user1 = new User("Vasya", 14, "Janitor", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
