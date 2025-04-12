package school.faang.BJS2_68411;

public class Main {
    public static void main(String[] args) {
        User correctUser = new User("Mark", 20, "Google", "London");

        try {
            User incorrectNameUser = new User("", 20, "Google", "London");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            User incorrectAgeUser = new User("Sam", 10, "Google", "London");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            User incorrectJobUser = new User("Robert", 20, "Microsoft", "London");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            User incorrectAddressUser = new User("John", 20, "Google", "Lisbon");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
