package school.faang.task.user.registration;


public class Main {
    public static void main(String[] args) {
        try {
            User firstUser = new User("Muslim", 31, "Google", "London");
            System.out.println(firstUser);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}

