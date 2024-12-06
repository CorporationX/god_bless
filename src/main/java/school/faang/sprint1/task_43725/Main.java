package school.faang.sprint1.task_43725;

public class Main {
    public static void main(String[] args) {
        try {
            new User(
                    18, "rauan", "London", "Google"
            );
            new User(
                    18, "John", "us", "office"
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
