package faang.school.godbless.BJS2_18460;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Ivan", 39, "Moscow", "Company1"),
                new User("Denis", 39, "Kazan", "Company1"),
                new User("Sergey", 40, "Kazan", "Company1"),
                new User("Vitaliy", 25, "Moscow", "Company4"),
                new User("Maria", 20, "Saint Petersburg", "Company3"),
                new User("Dmitry", 39, "Saing Petersburg", "Company3"),
                new User("Leonid", 25, "Nignekamsk", "Company5"),
                new User("Svetlana", 22, "Samara", "Company1"));

        Map<Integer, List<User>> map = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " age group:");
            entry.getValue().forEach(s -> System.out.println(s.getAge() + " - " + s.getName()));
            System.out.println("-----------------");
        }
    }
}
