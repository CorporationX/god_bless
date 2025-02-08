package faang.school.task_56544;

public class Main {
    public static void main(String[] args) {
        try {
            User testUser1 = new User("John", 23, "Amazon", "London");
            User testUser2 = new User("Chris", 16, "Uber", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
