package school.faang.sprint_1.task_bjs243706;

public class Main {
    public static void main(String[] args) {
        User validUser = new User("Mike", 18, "Google", "London");
        System.out.println(validUser);

        try {
            User userWithIncorrectAge = new User("Mike", 17, "Google", "London");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            User userWithIncorrectJob = new User("Mike", 18, "Yandex", "London");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            User userWithIncorrectAddress = new User("Mike", 18, "Google", "Moscow");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
