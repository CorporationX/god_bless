package school.faang.group;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        User userOleg = new User("Oleg", 23, "Google", "NY");
        User userOlga = new User("Olga", 30, "Yandex", "ER");
        User userIgor = new User("Igor", 30, "Google", "NY");
        User userMisha = new User("Misha", 43, "Google", "NY");
        User userMasha = new User("Masha", 19, "Google", "NY");

        List<User> userAgeList = List.of(userIgor, userMasha, userMisha, userOleg, userOlga);
        System.out.println(User.groupUserByAge(19, userAgeList));
    }
}
