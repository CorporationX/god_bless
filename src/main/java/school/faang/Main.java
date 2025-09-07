package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Mark", 22, "Google", "Под мостом");
        User user2 = new User("Un", 23, "Amazon", "Над мостом");
        User user3 = new User("Han", 22, "Uber", "Колотушкина");
        User user4 = new User("Mike", 18, "Yandex", "Мичурина");
        User user5 = new User("Fred", 18, "Sber", "Пушкина");

        List<User> users = List.of(user1, user2, user3, user4, user5);

        Map<Integer, List<User>> userMap = User.groupUsers(users);
        User.print(userMap);
    }
}
