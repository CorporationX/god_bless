package school.faang.BJS2_43967;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Иван", 20, "Зеленый банк", "Москва"));
        users.add(new User("Ольга", 35, "Желтый банк", "Санкт-Петербург"));
        users.add(new User("Сергей", 35, "Красный банк", "Новосибирск"));

        System.out.println(User.groupUsers(users));
    }
}
