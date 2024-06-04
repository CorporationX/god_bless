package faang.school.godbless.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Daniil", 23, "Cber", "NN"));
        users.add(new User("Mihail", 21, "Amazon", "USA"));
        users.add(new User("Ivan", 43, "Vk", "Msc"));
        users.add(new User("Slava", 26, "Cber", "Msc"));
        users.add(new User("Igor", 26, "Vk", "Spb"));
        users.add(new User("Tom", 26, "Cber", "Msc"));
        users.add(new User("Tonny", 21, "Vk", "Spb"));
        users.add(new User("Vadim", 23, "Cber", "Msc"));
        users.add(new User("Ismail", 33, "Uber", "Msc"));

        Map<Integer, List<User>> groups = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
