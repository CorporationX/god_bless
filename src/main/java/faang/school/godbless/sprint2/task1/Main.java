package faang.school.godbless.sprint2.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Zhenya", 21, "BC", "Moscow"));
        userList.add(new User("Pasha", 20, "Yandex", "St Petersburg"));
        userList.add(new User("Nikita", 22, "Uber", "Amsterdam"));
        userList.add(new User("Yan", 22, "Google", "New York"));
        userList.add(new User("Ivan", 22, "Netflix", "London"));
        Map<Integer, List<User>> tmp = User.groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : tmp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
