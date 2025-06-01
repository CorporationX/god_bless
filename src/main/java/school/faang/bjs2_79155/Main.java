package school.faang.bjs2_79155;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(21, "John", "Sber",
                "ул. Лесная, д. 14, кв. 27, г. Новосибирск, Россия, 630090"));
        users.add(new User(21, "John2", "Yandex",
                "пр-т Победы, д. 88А, г. Казань, Республика Татарстан, Россия, 420138"));
        users.add(new User(24, "Anna", "T-bank",
                "ул. Академика Королёва, д. 5, г. Москва, Россия, 129515"));
        users.add(new User(21, "Jack", "Sber",
                "ул. Центральная, д. 1, п. Зеленый Бор, Тверская обл., Россия, 170540"));
        users.add(new User(23, "Jill", "Yandex",
                "ул. Кирова, д. 23, кв. 10, г. Екатеринбург, Свердловская обл., Россия, 620014"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        User.printGroupedUsers(groupedUsers);
    }
}
