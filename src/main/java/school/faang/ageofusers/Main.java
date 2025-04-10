package school.faang.ageofusers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("Anton", 17, "home", "18 street"));
        users.add(new User("Grisha", 18, "home", "18 street"));
        users.add(new User("Anton1", 17, "home", "18 street"));
        users.add(new User("Anton2", 19, "home", "18 street"));
        users.add(new User("Anton4", 14, "home", "18 street"));
        users.add(new User("Anton3", 14, "home", "18 street"));

        System.out.println(User.groupUsers(users));
    }
}