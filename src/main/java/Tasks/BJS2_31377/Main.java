package Tasks.BJS2_31377;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = User.getUsersList();
        Map<Integer, List<User>> groupUser;

        System.out.println("Не отсортированный список пользователей");
        User.showUsers(users);
        groupUser = User.groupUser(users);
        System.out.println("Коллекции Map состоящий из ключа " + "возраста пользователей и списка пользователей");
        User.showUsersSortedByAge(groupUser);
    }
}
