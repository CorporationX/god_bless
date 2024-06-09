package faang.school.godbless.user;

public class Main {

    public static void main(String[] args) {

        try {
            User bob = new User("Bob", 24, "Motorola", "Germany");
            System.out.println(bob);

        } catch (IllegalArgumentException e) {
            System.out.println("Error");

        }

        try {
            User anna = new User("Anna", 24, "Google", "London");
            System.out.println(anna);
        } catch (IllegalArgumentException e) {
            System.out.println("Error");
        }
    }






}
