package school.faang.moduleone.task_43501;

public class Main {
    public static void main(String[] args) {
        checkUserCreationParams("", 20, "Uber", "London");
        checkUserCreationParams("Mark", 16, "Uber", "London");
        checkUserCreationParams("Mark", 20, "Romashka", "London");
        checkUserCreationParams("Mark", 20, "Uber", "Moscow");
    }

    private static void checkUserCreationParams(String name, Integer age, String job, String address) {
        try {
            new User(name, age, job, address);
        } catch (IllegalArgumentException e) {
            System.out.println("Ожидаемо поймали исключение c сообщением: " + e.getMessage());
        }
    }
}
