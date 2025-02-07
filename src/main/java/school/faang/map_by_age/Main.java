package school.faang.map_by_age;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("Vlad", 30, "Mac", "Lenina");
        User user2 = new User("Katya", 90, "L", "Pushkina");
        User user3 = new User("Oleg", 30, "Mac", "Lenina");
        User user4 = new User("Vasya", 17, "N", "Lenina");
        User user5 = new User("Olga", 30, "Mac", "Krasina");
        User user6 = new User("Masha", 17, "P", "Lenina");
        User user7 = new User("Lilya", 25, "L", "Lenina");
        User user8 = new User("Vova", 30, "M", "M");
        User user9 = new User("Kolya", 25, "V", "Lenina");
        User user10 = new User("Misha", 30, "Mac", "P");

        List<User> userList = new ArrayList<>(List.of(user1,
                user2,
                user3,
                user4,
                user5,
                user6,
                user7,
                user8,
                user9,
                user10));

        System.out.println(User.groupUsers(userList));
    }
}

