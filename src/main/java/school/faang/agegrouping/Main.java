package school.faang.agegrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", 20, "Вайлдберриз", "Санкт-Петербург"));
        users.add(new User("Мария", 24, "Астон", "Москва"));
        users.add(new User("Александр", 41, "МТС", "Екатеринбург"));
        users.add(new User("Сергей", 32, "OZON", "Норильск"));
        users.add(new User("Анастасия", 22, "Сбербанк", "Москва"));
        users.add(new User("Мария", 31, "Яндекс", "Казань"));
        users.add(new User("Павел", 41, "Пятерочка", "Саратов"));
        users.add(new User("Галина", 22, "Пятерочка", "Ростов"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Фильтр по возрасту: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" " + user);
            }
        }
    }
}