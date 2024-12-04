package school.faang.groupingUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Денис", 21, "Сбер", "А 1"));
        users.add(new User("Данил", 21, "Яндекс", "А 2"));
        users.add(new User("Кирилл", 18, "Рынок", "А 3"));
        users.add(new User("Артём", 25, "ВТБ", "А 4"));
        users.add(new User("Миша", 18, "Т-Банк", "А 5"));

        var groupedByAge = User.groupUsers(users);

        for (var sortedUsers : groupedByAge.entrySet()) {
            System.out.println("Возраст: " + sortedUsers.getKey());
            for (User user : sortedUsers.getValue()) {
                System.out.println(user);
            }
        }
    }
}
