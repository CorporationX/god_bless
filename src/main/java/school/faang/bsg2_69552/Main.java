package school.faang.bsg2_69552;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Иван Иванов", 25, "ООО Ромашка", "ул. Ленина, 10"));
        users.add(new User("Петр Петров", 30, "ЗАО Ветер", "ул. Гагарина, 5"));
        users.add(new User("Анна Сидорова", 25, "ИП Сидоров", "пр. Мира, 15"));
        users.add(new User("Мария Кузнецова", 30, "ООО Ромашка", "ул. Садовая, 3"));
        users.add(new User("Алексей Смирнов", 28, "ПАО Луна", "ул. Зеленая, 7"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
            System.out.println();
        }
    }
}
