package faang.school.godbless.userregistration;

public class RegistrationApp {

    public static void main(String[] args) {
        try {
            User user = new User("", 18, "Uber", "London");
        } catch (Exception e) {
            System.out.println(e + " Name is invalid");
        }
        try {
            User user = new User("Jon", 17, "Uber", "London");
        } catch (Exception e) {
            System.out.println(e + " Age is invalid");
        }
        try {
            User user = new User("Jon", 18, "Cleaner", "London");
        } catch (Exception e) {
            System.out.println(e + " Job is invalid");
        }
        try {
            User user = new User("Jon", 18, "Uber", "Moscow");
        } catch (Exception e) {
            System.out.println(e + " Address is invalid");
        }
    }

}
