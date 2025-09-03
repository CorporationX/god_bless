package school.faang.bjs2_85520;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User.userList = new ArrayList<>(Arrays.asList(new User("Daniel", 18, "Table", "Moscow"),
                new User("Dmitriy", 25, "Chair", "St.Petersburg"),
                new User("Taras", 25, "Palace", "Moscow"),
                new User("Denis", 18, "Table", "Tobolsk"),
                new User("Davincie", 25, "Chair", "Italia")));

        Map<Integer, List<User>> users = User.groupUsers(User.userList);
        for (var user : users.values()) {
            System.out.println(user.toString());
        }
    }
}
