package school.faang.BJS2_85788_1_1_2_1_age_grouping;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Ivan", "Sasha", "Mouse"};
        Integer[] ages = {10, 20, 20, 10, 1};
        String[] workspaces = {"Tea", "Office", "Cafe", "Nescafe", "Home"};
        String[] addresses = {"Wonderland", "London", "Paris", "St.Petersburg", "Room"};
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < names.length; i++) {
            users.add(new User(names[i], ages[i], workspaces[i], addresses[i]));
        }

        System.out.println(User.groupUsers(users));

    }

}