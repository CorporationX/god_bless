package school.faang.bjs2_68332;

/**
 * Задача "Регистрация пользователя"
 */
public class Main {
    public static void main(String[] args) {
        try {
            var user = new User("Петя", 18, "Сбер", "London"); //кидает Exception
            //var user = new User("Петя", 18, "Google", "London"); //проходит валидацию

            System.out.println(user);
        } catch (Exception e) {
            System.out.println("Ошибка валидации пользователя: " + e.getMessage());
        }
    }
}
