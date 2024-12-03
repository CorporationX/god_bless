package school.faang.task_43896;

import java.util.ArrayList;

import static school.faang.task_43896.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Миша", 36, "Библиотека", "Москва");
        User user2 = new User("Влад", 20, "Завод", "Самара");
        User user3 = new User("Саша", 20, "Фабрика", "Тула");
        User user4 = new User("Вася", 50, "Библиотека", "Тверь");

        ArrayList<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println(groupUsers(users));
    }
}
