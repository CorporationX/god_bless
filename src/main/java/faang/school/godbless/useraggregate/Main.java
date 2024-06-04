package faang.school.godbless.useraggregate;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User("Петя", 20, "Яндекс", "Москва"));
        listUsers.add(new User("Ваня", 20, "Яндекс", "Нижний Новгород"));
        listUsers.add(new User("Вася", 22, "Сбер", "Москва"));
        listUsers.add(new User("Миша", 22,"Сбер", "Тбилиси"));
        listUsers.add(new User("Саша", 22, "Сбер", "Екатеринбург"));
        listUsers.add(new User("Дима", 30, "ВТБ", "Сочи"));

        System.out.println(User.groupUsers(listUsers));
    }
}
