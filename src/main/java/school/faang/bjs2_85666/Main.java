package school.faang.bjs2_85666;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Алексей", 20, "МГУ", "Москва"),
                new User("Иван", 22, "Яндекс", "Москва"),
                new User("Мария", 20, "Сбербанк", "Санкт-Петербург"),
                new User("Ольга", 25, "Mail.ru", "Казань"),
                new User("Петр", 22, "Т-Банк", "Новосибирск"),
                new User("Анна", 20, "Ozon", "Москва")
        );

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.printf("Возраст %d: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
