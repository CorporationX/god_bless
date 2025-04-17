package school.faang.bjs2_69397;

import java.util.Arrays;

public class Main {
    public static void main (String [] args) {
        var users = Arrays.asList(
                new User("Владимир", 16, "Батуты", "г. Лукино"),
                new User("Путин", 23, "Ларек", "г. Сирия"),
                new User("Молодец", 54, "За углом", "г. Колодец"),
                new User("Красава", 37, "Там", "г. Лужа"),
                new User("Воообще", 9, "Пещера", "г. Река")
        );

        var groupedUsers = User.groupUsers(users);
        System.out.println(groupedUsers);
    }
}