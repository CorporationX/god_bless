package school.faang.sprint1.task_56341;

public class Main {
    public static void main(String[] args) {
        try {
            new User("Паша", 18, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Mistake: " + e.getMessage());
        }
    }
}
