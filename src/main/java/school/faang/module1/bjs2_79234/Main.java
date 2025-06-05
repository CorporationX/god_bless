package school.faang.module1.bjs2_79234;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        testUser("Alana", 21, "Google", "London");
        testUser("   ", 21, "Amazon", "New York");
        testUser("Alana", 12, "Google", "London");
        testUser("Alana", 18, "Facebook", "London");
        testUser("Alana", 18, "Google", "Belarus");
    }

    private static void testUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            log.info("Пользователь успешно создан: {}", user);
        } catch (IllegalArgumentException e) {
            log.error("Ошибка валидации: {}", e.getMessage());
        }
    }
}
