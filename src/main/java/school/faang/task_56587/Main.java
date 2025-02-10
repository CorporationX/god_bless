package school.faang.task_56587;

public class Main {
    public static void main(String[] args) {
        try {
            User badUser = new User("", 17, "Microsoft", "Berlin");
            User goodUser = new User("Anna", 22, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Print the error message to the console
        }
    }
}
