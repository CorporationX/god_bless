package school.faang.task_43714;

public class Main {
    public static void main(String[] args) {
        try {
            User dmitry = new User("Dmitry", 19, "Uber", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
