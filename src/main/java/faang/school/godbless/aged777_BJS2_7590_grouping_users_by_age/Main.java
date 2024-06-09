package faang.school.godbless.aged777_BJS2_7590_grouping_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
     /*
        Условия задачи:
        Создать класс User со следующими полями:
        имя;
        возраст;
        место работы;
        адрес.
        В этом же классе создать статический метод groupUsers, который принимает List из
        объектов User и возвращает Map, где ключом является возраст пользователя,
        а значением — список из всех пользователей в оригинальном списке, которые
        имеют соответствующий возраст.
      */
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(); // создаём список пользователей

        users.add(new User("Name1", 22, "Место работы 1", "Адрес 1"));
        users.add(new User("Name2", 23, "Место работы 2", "Адрес 2"));
        users.add(new User("Name3", 33, "Место работы 3", "Адрес 3"));
        users.add(new User("Name4", 33, "Место работы 4", "Адрес 4"));
        users.add(new User("Name5", 45, "Место работы 5", "Адрес 5"));
        users.add(new User("Name6", 19, "Место работы 6", "Адрес 6"));
        users.add(new User("Name7", 52, "Место работы 7", "Адрес 7"));
        users.add(new User("Name8", 31, "Место работы 8", "Адрес 8"));

        // задать вопрос - почему, если в поле name писать русскими буквами, ругается на первый символ
        // это из-за Lombok? почему в остальных полях не ругается?

        // демонстрация работы метода
        Map<Integer, List<User>> resultMap = User.groupUsers(users, 33);
        System.out.println(resultMap.get(33));

        Map<Integer, List<User>> resultMap2 = User.groupUsers(users, 22);
        System.out.println(resultMap2.get(22));

        User.groupUsers(users, 13);
    }
}
