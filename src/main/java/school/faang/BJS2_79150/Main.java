package school.faang.BJS2_79150;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Иван", 25, "Google", "Москва"),
                                    new User("Мария", 30, "Яндекс", "Киев"),
                                    new User("Олег", 25, "Meta", "Минск"),
                                    new User("Олег", 25, "Meta", "Минск"),
                                    new User("Олег", 25, "Meta", "Минск"),
                                    new User("Анна", 30, "Amazon", "Рига"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);

            }
        }
    }
}
