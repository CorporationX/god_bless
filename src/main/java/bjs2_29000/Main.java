package bjs2_29000;

public class Main {
    public static void main(String[] args) {
        User user = new User("Alex", 22, "Amazon", "Amsterdam");

        try {
            new User("", 22, "Amazon", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new User("Alex", 16, "Amazon", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new User("Alex", 22, "Yandex", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new User("Alex", 22, "Amazon", "Croatia");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
