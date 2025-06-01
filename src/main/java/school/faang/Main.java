package school.faang;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", 25, "Google", "Москва"));
        users.add(new User("Мария", 30, "Яндекс", "Киев"));
        users.add(new User("Олег", 25, "Meta", "Минск"));
        users.add(new User("Анна", 30, "Amazon", "Рига"));

        Map<Integer, List<User>> grouped = User.groupUsers(users);


        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User u : entry.getValue()) {
                System.out.println("  " + u);

            }
        }
    }
}
