package group.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static group.users.User.groupUsers;
import static group.users.User.printResult;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", 21, "Сбер", "ул. Веры Хоружей"));
        users.add(new User("Коля", 20, "Яндекс", "пр-т. Победы"));
        users.add(new User("Максим", 24, "Aston", "ул. Каховская"));
        users.add(new User("Андрей", 23, "Тиньков", "бульвар. Есенина"));

        Map<Integer, List<User>> grouped = groupUsers(users);
        groupUsers(users);
        printResult(grouped);
    }
}