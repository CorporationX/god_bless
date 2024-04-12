package faang.school.godbless.BJS2_5192;

public class Main {
    public static void main(String[] args) {
        System.out.println("Valid data test: User has been created correctly!");
        System.out.println();
        try {
            User userTest = new User("Serge", 26, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Invalid data test:");
        try {
            User userTest = new User("Serge", 26, "Google", "Phuket");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
