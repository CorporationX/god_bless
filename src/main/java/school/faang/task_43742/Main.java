package school.faang.task_43742;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Alice", 25, "Google", "London");
            System.out.println("User successfully created!");
            User unvalidUser = new User("Bob", 16, "Teacher", "Paris");
        }catch (IllegalArgumentException e){
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
