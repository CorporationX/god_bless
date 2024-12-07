package school.faang.TaskGroupingUsersByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("Alex", 23, "Epam", "Lenina 21"));
        usersList.add(new User("Viktor", 44, "T-bank", "Lenina 23"));
        usersList.add(new User("Max", 14, "Sber", "Lenina 22"));
        usersList.add(new User("Serega", 61, "Sber", "Lenina 24"));
        usersList.add(new User("Egor", 32, "Yandex", "Lenina 25"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(usersList);
        for (Map.Entry<Integer, List<User>> currentUser : groupedUsers.entrySet()) {
            System.out.println("Age: " + currentUser.getKey() + ", Users: " + currentUser.getValue());
        }
    }
}

