package school.faang.task56383;

public class Main {
    public static void main(String[] args) {
        try {
            User testUser = new User("Вася", 25, "Uber", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания пользователя.");
        }
    }
}
