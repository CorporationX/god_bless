package faang.school.godbless.Sprint_1.Java_Core.BJS2_4216;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task_2 {
    public static void main(String[] args) {
        User user1 = new User("Иван", 15, "ООО 'Рога и копыта'", "ул. Ленина, д. 1");
        User user2 = new User("Петр", 32, "ООО 'Сила и мощь'", "ул. Мира, д. 5");
        User user3 = new User("Мария", 25, "ООО 'Успех'", "ул. Гагарина, д. 10");
        User user4 = new User("Сергей", 25, "ООО 'Буспех'", "ул. Гагарина, д. 10");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        System.out.println(groupedUsers);

    }
}

