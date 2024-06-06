package faang.school.godbless.BJS27834;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();
        users.add(new User("Gena", 24, "Google", "London"));
        users.add(new User("Yaroslav", 24, "Uber", "Amsterdam"));
        users.add(new User("Maksim", 33, "Google", "London"));
        users.add(new User("Konstantin", 33, "Amazon", "New York"));

        for (var pair : User.groupUsers(users).entrySet()) {
            System.out.println(pair.getKey());
            for (User user : pair.getValue()) {
                System.out.println(user.toString());
            }
        }
    }
}
