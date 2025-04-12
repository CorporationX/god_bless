package school.faang.user_registration;

import school.faang.user_registration.models.User;

public class Main {
    public static void main(String[] args) {
        try {
            // Корректный пользователь
            User user1 = new User("Petr", 19, "Google", "London");
            System.out.println("Пользователь создан: " + user1.getName());

            // Некорректный пользователь (вызовет исключение)
            User user2 = new User("    ", 17, "Microsoft", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания пользователя: " + e.getMessage());
        }

    }
}
