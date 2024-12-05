package school.faang.sprint1.bjs_43995;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = addUsersInList();
        Map<Integer, List<User>> result = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.getName());
            }
        }
    }

    public static List<User> addUsersInList() {
        List<User> users = new ArrayList<>();
        String[][] userData = {
                {"Tom", "25", "Google", "London"},
                {"Mark", "26", "Yandex", "Paris"},
                {"Sam", "27", "Amazon", "New York"},
                {"Oliver", "25", "Google", "London"},
                {"Jack", "26", "Amazon", "New York"},
                {"Peter", "27", "Yandex", "Paris"}
        };

        for (String[] user : userData) {
            String name = user[0];
            int age = Integer.parseInt(user[1]);
            String job = user[2];
            String address = user[3];
            users.add(new User(name, age, job, address));
        }

        return users;
    }
}
