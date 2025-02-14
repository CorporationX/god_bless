package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("", 25, "Google", "London");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            User user = new User("Alex", 17, "Google", "London");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            User user = new User("Alex", 18, "VKontakte", "London");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            User user = new User("Alex", 18, "Google", "Moscow");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
