package faang.school.godbless.groupUsers;

import java.util.ArrayList;

public class Application {
    public static void main(String... args) {
        User user1 = new User("Artem", 22, "Improvado", "Almaty");
        User user2 = new User("Nikita", 23, "Microsoft", "Antalia");
        User user3 = new User("Dominic", 21, "XTeam", "Roma");
        User user4 = new User("Nastya", 30, "Lotte", "Moscow");
        User user5 = new User("Pavel", 5, null, "Tambov");

        ArrayList<User> list = new ArrayList<>(){{
            add(user4);
            add(user5);
            add(user2);
            add(user3);
            add(user1);
        }};
        System.out.println(User.groupUsers(list));
    }
}

