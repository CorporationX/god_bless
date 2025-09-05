package school.faang.bjs2_85587;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Олег", 26, "Конструкторское бюро", "Москва"));
        users.add(new User("Ирина", 25, "Банк ВТБ", "Москва"));
        users.add(new User("Антон", 26, "Магазин Пятерочка", "Нижний Новгород"));
        users.add(new User("Николай", 28, "Школьный буфет", "Санкт-Петербург"));
        users.add(new User("Марина", 25, "Тренажерный зал", "Владивосток"));
        users.add(new User("Артем", 26, "Музей тульского пряника", "Тула"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey() + "\nПользователи:");
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
