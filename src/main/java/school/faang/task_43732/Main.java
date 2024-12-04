package school.faang.task_43732;

public class Main {
    public static void main(String[] args) {
        try {
            var user = new User("Денис", 25, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            var user = new User("Даниил", 17, "Amazon", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            var user = new User("Кирилл", 30, "Facebook", "Berlin");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
