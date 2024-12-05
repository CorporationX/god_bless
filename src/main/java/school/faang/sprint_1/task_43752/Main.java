package school.faang.sprint_1.task_43752;

public class Main {
    public static void main(String[] args) {
        try {
            User firstUser = new User("Nina", 18, "Google", "London");
            User secondUser = new User("Sergey", 17, "Uber", "New York");
            System.out.println(firstUser);
            System.out.println(secondUser);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
