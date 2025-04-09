package school.faang.group_by_age;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserAge userOleg = new UserAge("Oleg", 23, "Google", "NY");
        UserAge userOlga = new UserAge("Olga", 30, "Yandex", "ER");
        UserAge userIgor = new UserAge("Igor", 30, "Google", "NY");
        UserAge userMisha = new UserAge("Misha", 43, "Google", "NY");
        UserAge userMasha = new UserAge("Masha", 19, "Google", "NY");

        List<UserAge> userAgeList = List.of(userIgor, userMasha, userMisha, userOleg, userOlga);
        System.out.println(UserAge.groupUserByAge(19, userAgeList));
    }
}
