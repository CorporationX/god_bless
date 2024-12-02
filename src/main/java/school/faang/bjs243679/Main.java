package school.faang.bjs243679;

public class Main {
    public static void main(String[] args) {
        // Invalid name
        try {
            new User("", 18, "Google", "Amsterdam");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Invalid age
        try {
            new User("Pavel", 17, "Google", "Amsterdam");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Invalid job
        try {
            new User("Pavel", 18, "Gooooooooogle", "Amsterdam");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Invalid address
        try {
            new User("Pavel", 18, "Google", "Moscow");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Success
        new User("Pavel", 18, "Google", "Amsterdam");
    }
}
