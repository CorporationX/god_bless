package school.faang;

public class Main {

    public static void main(String[] args) {
        User user = new User("Alex", 21, "Google", "New York");
        try {
            user = new User("", 20, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            user = new User("Alex", 10, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            user = new User("Alex", 20, "", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            user = new User("Alex", 20, "Google", "");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
