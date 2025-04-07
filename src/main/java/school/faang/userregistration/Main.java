package school.faang.userregistration;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Nazar", 23, "Amazon", "Amsterdam");
            System.out.println("User has been created: " + user.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
