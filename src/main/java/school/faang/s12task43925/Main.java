package school.faang.s12task43925;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.s12task43925.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Anton", 30, "NPO", "Arkhangelsk"));
        users.add(new User("Saveliy", 35, "NII", "Orel"));
        users.add(new User("Oleg", 24, "KB", "Nigniy Novgorod"));
        users.add(new User("Kirill", 35, "OKB", "Velikiy Novgorod"));

        Map<Integer, List<User>> grouped = groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" - " + user.getName() + ": " + user.getWorkplace() + ", " + user.getAddress());
            }
        }
    }
}