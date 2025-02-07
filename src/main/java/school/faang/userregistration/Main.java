package school.faang.userregistration;

public class Main {
    public static void main(String[] args) {

        try {
            User normalUser = new User("Alex", 20, "Google", "London");

            User illegalUser = new User(" ", 17, "faang", "Street1");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
