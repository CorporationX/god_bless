package GroupingUsersByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static GroupingUsersByAge.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Денис", 35, "Трансстройбанк", "г. Москва"));
        userList.add(new User("Саша", 40, "Самозанятый", "г. Санкт-Петербург"));
        userList.add(new User("Николай", 63, "Пенсионер", "Сидит дома"));

        Map<Integer, List<User>> groupedUser = groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : groupedUser.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
