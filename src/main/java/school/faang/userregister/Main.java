package school.faang.userregister;

public class Main {
    public static void main(String[] args) {
        try {
            User anny = new User("Anny", 25, "Google", "Amsterdam");
            User kenny = new User("Kenny", 29, "Uber", "Berlin");
            User louis = new User("Louis", 32, "Amazon", "New York");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
