package school.faang.bjs2_79225_registration;

public class Main {
    public static void main(String[] args) {
        try {
            User userAllOk = new User("Bob", 20, "Amazon", "London");
            System.out.println("userAllOk successfully created");
        } catch (Exception e) {
            System.out.println("userAllOk. Caught exception: " + e.getMessage());
        }

        try {
            User userNullName = new User(null, 20, "Amazon", "London");
        } catch (Exception e) {
            System.out.println("userNullName. Caught exception: " + e.getMessage());
        }

        try {
            User userUnderage = new User("Mark", 2, "Amazon", "London");
        } catch (Exception e) {
            System.out.println("userUnderage. Caught exception: " + e.getMessage());
        }

        try {
            User userBadJob = new User("Pete", 20, "AmazonX", "London");
        } catch (Exception e) {
            System.out.println("userBadJob. Caught exception: " + e.getMessage());
        }

        try {
            User userBadAddress = new User("Alice", 20, "Amazon", "LondonX");
        } catch (Exception e) {
            System.out.println("userBadAddress. Caught exception: " + e.getMessage());
        }

        try {
            User userAllBad = new User("", 2, "AmazonX", "LondonX");
        } catch (Exception e) {
            System.out.println("userAllBad. Caught exception: " + e.getMessage());
        }

    }
}
