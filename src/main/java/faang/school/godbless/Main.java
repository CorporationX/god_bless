package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //UserGroup.groupUsers();

        List<App> list = Arrays.asList(
                new App("Sasha", 25, "VK", "Moscow"),
                new App("Behzod", 24, "MTC", "S.Petersburg"),
                new App("Masha", 30, "Sber", "Kazan"));

        Map<Integer, List<App>> groupedUser = App.groupUsers(list);

        groupedUser.forEach((age, users) -> {
            System.out.println(age + ":");
            users.forEach(user -> System.out.println("Names" + user.getName()));
            System.out.println();
        });

    }
}
