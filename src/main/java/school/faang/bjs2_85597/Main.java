package school.faang.bjs2_85597;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Bob", 17, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}