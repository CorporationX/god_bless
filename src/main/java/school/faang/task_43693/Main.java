package school.faang.task_43693;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Jeff Bezos", 60, "Amazon", "New York");
            User invalidUser = new User("Sergey Brin", 51, "Google", "California");
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
