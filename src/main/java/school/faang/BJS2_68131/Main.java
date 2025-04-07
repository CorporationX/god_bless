package school.faang.BJS2_68131;

public class Main {
    public static void main(String[] args) {
        User correctUser = new User("Mike", 19, "Google", "London");
        System.out.println(correctUser);

        try {
            User incorrectUser = new User("NN", 12, "Google", "London");
            System.out.println(incorrectUser);
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred creating user: " + e.getMessage());
        }
    }
}
