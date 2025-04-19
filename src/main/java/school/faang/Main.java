package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("Иван", 23, "Магнит", "м.Бибирево"));
        usersList.add(new User("Петр", 13, "Пятерочка", "м.Алтуфьево"));
        usersList.add(new User("Максим", 53, "Дикси", "м.Бибирево"));
        usersList.add(new User("Василий", 23, "Яндекс", "м.Медведково"));
        usersList.add(new User("Даниил", 23, "Т-банк", "м.Бибирево"));
        Map<Integer, List<User>> resultMap = User.groupUsers(usersList);
        System.out.println(resultMap);

    }
}

