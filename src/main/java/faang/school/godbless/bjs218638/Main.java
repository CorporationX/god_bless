package faang.school.godbless.bjs218638;

public class Main {
    public static void main(String[] args) {
        User validUser = new User("Alice", 30, "Google", "London");
        System.out.println(validUser);
        try {
            User invalidUser = new User("", 18, "Uber", "New York");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
