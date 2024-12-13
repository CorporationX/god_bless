package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            new User("Oleg", 35, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("", 35, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 17, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 35, "VK", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
        try {
            new User("Oleg", 35, "Amazon", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println("Catch exception " + e.getMessage());
        }
    }
}
