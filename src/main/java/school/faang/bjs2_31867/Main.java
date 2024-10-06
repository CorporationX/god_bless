package school.faang.bjs2_31867;

public class Main {
    public static void main(String[] args) {
        testNameIsNull();
        testNameIsEmpty();
        testNameIsBlank();

        testAgeIsNull();
        testAgeIsLessThan18();

        testJobLocationNotInValidJobs();
        testAddressNotInValidAddresses();

        testValidArgs();
    }

    private static void testNameIsNull() {
        try {
            new User(null, 20, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }

    private static void testNameIsEmpty() {
        try {
            new User("", 20, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testNameIsBlank() {
        try {
            new User(" ", 20, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testAgeIsNull() {
        try {
            new User("Max", null, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testAgeIsLessThan18() {
        try {
            new User("Max", 15, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testJobLocationNotInValidJobs() {
        try {
            new User("Max", 20, "OpenAI", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            new User("Max", 20, null, "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testAddressNotInValidAddresses() {
        try {
            new User("Max", 20, "Google", "Atlanta");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            new User("Max", 20, "Google", null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void testValidArgs() {
        User user = new User("Max", 20, "Google", "London");
        System.out.println("testValidArgs: " + user);
    }

}
