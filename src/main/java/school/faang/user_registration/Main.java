package school.faang.user_registration;

import school.faang.user_registration.models.User;

public class Main {
    public static void main(String[] args) {
        try {
            User correctUser = new User("Petr", 19, "Google", "London");
            System.out.println("Пользователь создан: " + correctUser.getName());

            User incorrectUser = new User("    ", 17, "Microsoft", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания пользователя: " + e.getMessage());
        }
    }
}
