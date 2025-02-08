package faang.school.task_56544;

public class Main {
    public static void main(String[] args) {
        try {
            User testUser1 = new User("John", 23, "Amazon", "London");
            User testUser2 = new User("Chris", 16, "Uber", "Amsterdam");
            User testUser3 = new User("James", 33, "Microsoft", "New York");
            User testUser4 = new User("Jack", 26, "Google", "Paris");
            User testUser5 = new User(" ", 29, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
