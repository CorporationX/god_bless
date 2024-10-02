package school.faang;

public class Main {
    public static void main(String[] args) {

        try {
            new User("Alex", 20, "Google", "London");
            System.out.println("It's OK");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
