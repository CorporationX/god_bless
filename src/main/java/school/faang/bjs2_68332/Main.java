package school.faang.bjs2_68332;

/**
 * Задача "Регистрация пользователя"
 */
public class Main {
    public static void main(String[] args) {
        registerUser("Петя", 18, "Google", "New York");
        registerUser("Коля", 45, "Google", "Москва");
        registerUser("Вася", 13, "Школьник", "London");
        registerUser("Дима", 22, "Сбер", "Amsterdam");
    }

    public static void registerUser(String name, int age, String job, String address) {
        try {
            var user = new User(name, age, job, address);

            System.out.println(user);
        } catch (Exception e) {
            System.out.printf("Ошибка валидации пользователя: %s%n", e.getMessage());
        }
    }
}
