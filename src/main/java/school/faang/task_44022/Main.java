package school.faang.task_44022;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        int j = 0;
        for (int i = 0; i < 10; i++) {
            User tempUser = new User("Sergey_" + i, j, "FAANG_" + i, "_" + i);
            users.add(tempUser);
            if (i % 2 == 0) {
                j += 1;
            }
        }

        Map<Integer, ArrayList<User>> ansMap = User.groupUsers(users);

        for (Map.Entry<Integer, ArrayList<User>> entry : ansMap.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User userTemp : entry.getValue()) {
                System.out.println(userTemp.getName());
            }
        }
    }
}
