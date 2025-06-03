package school.faang.bjs2_79225_registration;

public class Main {
    public static void main(String[] args) {

        tryCreateUser("userAllOk", 20, "Amazon", "London");
        tryCreateUser(null, 20, "Amazon", "London");
        tryCreateUser("userUnderage", 2, "Amazon", "London");
        tryCreateUser("userBadJob", 20, "AmazonX", "London");
        tryCreateUser("userBadAddress", 20, "Amazon", "LondonX");
        tryCreateUser("", 2, "AmazonX", "LondonX");

    }

    public static void tryCreateUser(String name, int age, String job, String address) {
        try {
            new User(name, age, job, address);
            System.out.println("User " + name + " successfully created");
        } catch (Exception e) {
            if (!Util.hasText(name)) {
                name = "(null or empty name)";
            }
            System.out.println("Creating " + name + ". Caught exception: " + e.getMessage());
        }
    }
}
