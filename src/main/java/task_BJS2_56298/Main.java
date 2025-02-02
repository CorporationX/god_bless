package task_BJS2_56298;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        addElements(users);

        System.out.println(User.groupUsers(users));

    }

    private static List<User> addElements(List<User> collection) {
        collection.add(new User("Anton", 25, "VTB", "Moscow"));
        collection.add(new User("Bob", 25, "Sber", "Rostov"));
        collection.add(new User("Sam", 18, "Google", "Moscow"));
        collection.add(new User("Mike", 19, "Yandex", "Voronezh"));

        return collection;
    }

}
