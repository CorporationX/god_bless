package faang.school.godbless.bjs2_7565;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Vlad", 36, "Yandex", "Vyazov st. 13");
        User user2 = new User("Nikolay", 30, "Yandex", "Vyazov st. 13");
        User user3 = new User("Olga", 24, "Yandex", "Vyazov st. 13");
        User user4 = new User("Evgeniy", 36, "Uber", "Vyazov st. 13");
        User user5 = new User("Mikhail", 24, "Sber", "Vyazov st. 13");
        User user6 = new User("Artur", 30, "Uber", "Vyazov st. 13");
        User user7 = new User("Katya", 30, "Yandex", "Vyazov st. 13");
        User user8 = new User("Svetlana", 19, "Sber", "Vyazov st. 13");
        User user9 = new User("Egor", 24, "Uber", "Vyazov st. 13");
        User user10 = new User("Ilya", 20, "Sber", "Vyazov st. 13");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);

        for (Map.Entry entry : User.groupUsers(users).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
