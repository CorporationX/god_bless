package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //UserGroup.groupUsers();

        List<UserGroup> list= Arrays.asList(
                new UserGroup("Sasha", 25, "VK", "Moscow"),
                new UserGroup("Behzod", 24, "MTC", "S.Petersburg"),
                new UserGroup("Masha", 30, "Sber", "Kazan"));

        Map<Integer, List<UserGroup>> groupedUser=UserGroup.groupUsers(list);

        groupedUser.forEach((age, users)->{
            System.out.println(age + ":" );
            users.forEach(user->System.out.println("Names" + user.getName()));
            System.out.println();
        });

    }
}
