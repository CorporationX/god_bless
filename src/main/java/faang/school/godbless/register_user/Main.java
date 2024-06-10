package faang.school.godbless.register_user;

public class Main {
    public static void main(String[] args) {
        var user = new User("Kostya", 20, "Google", "London");
        System.out.println(user);
        try {
            var errorUser = new User("Artur", 17, "Google", "Prague");
            System.out.println(errorUser);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        }
    }
}
