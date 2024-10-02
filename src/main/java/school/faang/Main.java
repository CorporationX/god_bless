package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Аслан", "Пушкина 51", "Менеджер", 35));
        users.add(new User("Арман", "Абылайхана 1", "Маркетолог", 28));
        users.add(new User("Станислав", "Шевченко 11", "Разработчик", 23));
        users.add(new User("Таисия", "Абая 103", "Бухгалтер", 29));
        users.add(new User("Батырхан", "село Абай", "Курьер", 20));

        for (Map.Entry<Integer, List<User>> result : groupUsers(users).entrySet()) {
            if (result.getKey() == 35) {
                System.out.println(result.getValue());
            }
        }
    }
}
