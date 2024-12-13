package school.faang.task_43782;

public class Main {
    public static void main(String[] args) {
        try {
            User userWithExceptionAge = new User("Sergey", 17, "Google", "London");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception + " - this exception was found");
        }

        try {
            User userWithExceptionWorkplace = new User("Sergey", 18, "Yandex", "London");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception + " - this exception was found");
        }

        try {
            User userWithExceptionAddress = new User("Sergey", 17, "Google", "Moscow");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception + " - this exception was found");
        }

        User userWithoutException = new User("Ivan", 40, "Google", "London");

    }
}
