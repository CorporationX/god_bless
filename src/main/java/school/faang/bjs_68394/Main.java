package school.faang.bjs_68394;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Аня", 25, "Google", "Москва, ул. Ленина, 1"));
        users.add(new User("Иван", 25, "Amazon", "Казань, Баумана, 7"));
        users.add(new User("Олег", 30, "VK", "Новосибирск, Красный проспект, 5"));
        users.add(new User("Светлана", 35, "Сбер", "Екатеринбург, Малышева, 3"));

        Map<Integer, List<User>> grouped = User.groupUsers();
        System.out.println(users);

    }
}
