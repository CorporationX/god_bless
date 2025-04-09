package school.faang;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ben", 23, "Uber", "Amsterdam");
        User user2 = new User("Mira", 19, "Google", "London");
        System.out.println(user2 + " " + user);

        try {
            User incorrectUser = new User(" ", 9, "Google", "London");
            System.out.println(incorrectUser);
        } catch (IllegalArgumentException e) {
            System.out.println("the information is filled out incorrectly" + e.getMessage());
        }
    }
}
