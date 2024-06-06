package faang.school.godbless.BJS27572;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();
        users.add(new User("Gena", 24, "GDM", "Volgonosk"));
        users.add(new User("Yaroslav", 24, "GDM", "Volgonosk"));
        users.add(new User("Maksim", 33, "GDM", "Volgonosk"));
        users.add(new User("Konstantin", 33, "GDM", "Volgonosk"));

        for (var pair : User.groupUsers(users).entrySet()) {
            System.out.println(pair.getKey());
            for (User user : pair.getValue()) {
                System.out.println(user.toString());
            }
        }
    }
}
