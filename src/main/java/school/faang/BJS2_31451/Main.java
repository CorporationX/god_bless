package school.faang.BJS2_31451;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
            new User("Губка Боб", 36, "Повар", "Ананас"),
            new User("Патрик", 36, "Домохозяин", "Камень"),
            new User("Сквидвард", 43, "Кассир", "Каменая бошка"),
            new User("Сенди", 33, "Ученая", "Аквариум")
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(userList);

        groupedUsers.forEach((age, users) -> {
            System.out.println("Age: " + age);
            users.forEach(System.out::println);
        });
    }
}

