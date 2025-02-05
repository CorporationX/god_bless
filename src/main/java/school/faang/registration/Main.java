package school.faang.registration;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Alice", 23, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


