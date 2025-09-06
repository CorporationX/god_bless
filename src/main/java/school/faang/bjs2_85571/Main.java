package school.faang.bjs2_85571;

public class Main {
    public static void main(String[] args) {
        User newUser;
        try {
            newUser = new User("Олег", 18, "Google", "London");
            System.out.println(newUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
