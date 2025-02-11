package school.faang.sprint1.task_56308;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        try {
            userList.add(new User("Андрей", 19, "Работа 1", "andr.com"));
            userList.add(new User("Артур", 19, "Работа 2", "art.com"));
            userList.add(new User("Толя", 33, "Работа-3", "tol.com"));
            userList.add(new User("Оксана", 33, "Работа 4", "oks.com"));
            userList.add(new User("Арина", 19, "Работа 5", "ari.com"));
        } catch (IllegalAccessError e) {
            System.out.println("Mistake: " + e.getMessage());
        }

        Map<Integer, List<User>> map = User.groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " --- Users:  " + entry.getValue());
        }
    }
}
