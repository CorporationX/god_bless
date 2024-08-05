package faang.school.godbless.groupusersbyage;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Павел", 26, "Повар", "Москва"),
                new User("Дмитрий", 29, "Пожарный", "Калуга"),
                new User("Юрий", 33, "Программист", "Воронеж"),
                new User("Даниил", 33, "Врач", "Сочи")
        );

        Map<Integer, List<User>> groupedUsersMap = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsersMap.entrySet()) {
            System.out.printf("Возраст: %s, Пользователи: %s%n", entry.getKey(), entry.getValue());
        }
    }
}