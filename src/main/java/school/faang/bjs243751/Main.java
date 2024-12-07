package school.faang.bjs243751;

public class Main {

    public static void main(String[] args) {

        try {
            new User("Bob", 25, "Google", "London");
            new User("Bob", 25, "Google", "");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error!" + ex);
        }
    }
}