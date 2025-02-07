package school.faang.groupUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Garry", 18, "Google", "London"));
        users.add(new User("Hermiona", 18, "Hogwards", "Vesteros"));
        users.add(new User("Ron", 19, "Amazone", "Frankfurt"));
        users.add(new User("Dolgopups", 20, "Netflix", "Amsterdam"));

        System.out.println(User.groupUsers(users));
    }

}
