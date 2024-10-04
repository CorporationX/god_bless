package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User dima = new User("Дима", 20, "Сбер", "г.Москва");
        User sasha = new User("Саша", 23, "Роснефть", "г.Самара");
        User dasha = new User("Даша", 20, "Альфабанк", "Уфа");

        List<User> users = new ArrayList<>();
        users.add(dima);
        users.add(sasha);
        users.add(dasha);

        Map<Integer, List<User>> sortedUsers;
        sortedUsers = User.groupUsers(users);
        System.out.println(sortedUsers);
    }
}
