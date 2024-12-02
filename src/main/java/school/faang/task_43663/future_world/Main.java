package school.faang.task_43663.future_world;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Alex", 18, "Google", "London");
            System.out.println("Пользователь создан: " + validUser);

            User invalidUser = new User("", 17, "ne Amazon", "ne London");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибки при создании пользователя:\n" + e.getMessage());
        }
    }
}
