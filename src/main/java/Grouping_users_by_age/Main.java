package Grouping_users_by_age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List <User> users = new ArrayList<>();
        users.add(new User("Kirill", 18, "Amazon", "Street1"));
        users.add(new User("Kristina", 17, "Google", "Street2"));
        users.add(new User("Vika", 20, "Apple", "Street3"));
        users.add(new User("Vlad", 25, "Shaverma", "Street4"));

        Map <Integer, List <User>> map = User.groupUsers(users);
        for (var entry : map.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            for (var value : entry.getValue()) {
                System.out.print(value.getName());
            }
            System.out.println();
        }
    }

}
