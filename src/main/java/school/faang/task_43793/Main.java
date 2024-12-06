package school.faang.task_43793;

public class Main {
    public static void main(String[] args) {
        try {
            User john = new User("John", 16, "Facebook", "Paris");
            System.out.println("User created successfully: " + john);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create user: " + e.getMessage());
        }
        try {
            User john = new User("John", 20, "Facebook", "London");
            System.out.println("User created successfully: " + john);
            try {
                john.setJob("Paris");
                System.out.println("Workplace changed successfully: " + john);
            } catch (IllegalArgumentException e) {
                System.err.println("Failed to change workplace: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create user: " + e.getMessage());
        }
    }
}
