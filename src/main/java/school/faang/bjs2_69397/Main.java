package school.faang.bjs2_69397;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String [] args) {
        List<User> users = Arrays.asList(
                new User("Владимир", 16, "Батуты", "г. Лукино"),
                new User("Путин", 23, "Ларек", "г. Сирия"),
                new User("Молодец", 54, "За углом", "г. Колодец"),
                new User("Красава", 37, "Там", "г. Лужа"),
                new User("Воообще", 9, "Пещера", "г. Река")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        System.out.println(groupedUsers);
    }
}