package school.faang.sprintone.usercollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activities1 = Set.of("Футбол", "Шахматы");
        User user1 = new User(1, "Iван", 25, activities1);

        Set<String> activities2 = Set.of("Плавание", "Теннис");
        User user2 = new User(2, "Ольга", 30, activities2);

        Map<User, String> result = User.findHobbyLovers(
                List.of(user1, user2),
                Set.of("Теннис", "Шахматы")
        );

        System.out.println("Вот пользователи, которые выбрали наши активности:");
        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.printf("Пользователь: %s; Активность - %s%n", entry.getKey().getName(), entry.getValue());
        }
    }
}