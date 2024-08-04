package faang.school.godbless.groupusersbyage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static final List<User> USER_LIST = new ArrayList<>();

    public static void main(String[] args) {
        USER_LIST.add(new User("Павел", 26, "Повар", "Москва"));
        USER_LIST.add(new User("Дмитрий", 29, "Пожарный", "Калуга"));
        USER_LIST.add(new User("Юрий", 33, "Программист", "Воронеж"));
        USER_LIST.add(new User("Даниил", 33, "Врач", "Сочи"));

        Map<Integer, List<User>> groupedUsersMap = User.groupUsers(USER_LIST);
        for (Map.Entry<Integer, List<User>> entry : groupedUsersMap.entrySet()) {
            System.out.println(entry);
        }
    }
}