package faang.school.godbless;

import java.util.ArrayList;

public class Application {
    public static void main(String... args) {
        User user1 = new User("Ivan", 25, "Work1", "Address1");
        User user2 = new User("Sveta", 25, "Work2", "Address2");
        User user3 = new User("Igor", 30, "Work2", "Address3");
        User user4 = new User("Semen", 30, "Work2", "Address4");
        User user5 = new User("Liza", 5, null, "Address5");

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
