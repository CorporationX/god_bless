package school.faang.usergrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Masha", 50, "Nurse", "Belarus, Mogilev"));
        users.add(new User("Dasha", 22, "Developer", "Belarus, Minsk"));
        users.add(new User("Lyosha", 33, "Finance", "Belarus, Mogilev"));
        users.add(new User("Pasha", 32, "Developer", "Belarus, Grodno"));
        users.add(new User("Sasha", 22, "Analyst", "Belarus, Minsk"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> groupedUser : groupedUsers.entrySet()) {
            for (User user : groupedUser.getValue()) {
                System.out.println(groupedUser.getKey() + " - "
                        + user.getName() + ", " + user.getWorkplace());
            }
        }
    }
}
